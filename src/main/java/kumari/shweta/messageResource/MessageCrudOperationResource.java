package kumari.shweta.messageResource;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Shweta Kumari
 */

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import kumari.shweta.MessagingAPI.Exception.DataNotFoundException;
import kumari.shweta.MessagingAPI.Exception.DataNotFoundExceptionMapper;
import kumari.shweta.MessagingAPI.model.Message;
import kumari.shweta.MessagingAPI.service.MessagesService;

@Path("messagecrud")
@Produces(value= {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Consumes(value= {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class MessageCrudOperationResource {
	MessagesService messagesService = new MessagesService();

	@GET
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public List<Message> getAllMessages() {
		return messagesService.getAllMessages();
	}

	/*
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessages(Message messages) {
		return messagesService.addMessage(messages);
	}
	*/
	
	/*
	Send Response to  Server along with Status 
	Status.CREATED -201 
	by default status should be 200
	*/
	
	/*@POST
	public Response addMessage(Message message) {
		Message newMessage = messagesService.addMessage(message);
		return Response.status(Status.CREATED).entity(newMessage).build();
	}
	*/
	

	//Send URI in header .In header section, Location header value shows uri along with message id 
/*	
	@POST
	public Response addMessage(Message message) throws URISyntaxException {
		Message newMessage = messagesService.addMessage(message);
		return Response.created(new URI("/MessagingAPI/webapi/messagecrud/" + newMessage.getId() )).entity(newMessage).build();
	}
*/	
	//In above method we are passing hardcode uri we, Let us make it dymanic 
	
	@POST
	public Response addMessage(Message message,@Context UriInfo uriInfo) {
		Message newMessage=messagesService.addMessage(message);
		String newId=String.valueOf(message.getId());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
		
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id,@Context UriInfo uriInfo) {
		
		Message message=messagesService.getMessage(id);
		String url = getSelfURL(uriInfo, message);
		String profileUrl=getProfileUrl(uriInfo, message);
		if(message==null) {
			throw new DataNotFoundException("Data not found at message id "+id);
		}
		message.addLink(url, "self");
		message.addProfile(profileUrl, "profile");
		return message;

	}

	private String getProfileUrl(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder().path(ProfileCrudOperationResource.class).path(message.getAuthor()).build().toString();
	}

	private String getSelfURL(UriInfo uriInfo, Message message) {
		String url=uriInfo.getBaseUriBuilder().path(MessageCrudOperationResource.class).path(Long.toString(message.getId())).build().toString();
		return url;
	}



	@PUT
	@Path("/{messageId1}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessages(@PathParam("messageId1") long id, Message message) {
		message.setId(id);
		return messagesService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		messagesService.removeMessage(id);

	}
	//Implementing Subresource 

	@Path("/{messageId}/comments")
	public CommenResource test() {
		return new CommenResource();
		
	}
	

}
