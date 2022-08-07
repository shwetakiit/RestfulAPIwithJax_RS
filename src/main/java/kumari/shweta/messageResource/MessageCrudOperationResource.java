package kumari.shweta.messageResource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kumari.shweta.MessagingAPI.model.Message;
import kumari.shweta.MessagingAPI.service.MessagesService;

@Path("messagecrud")
public class MessageCrudOperationResource {
	MessagesService messagesService= new MessagesService();	
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Message> getAllMessages(){
	
	return messagesService.getAllMessages();
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message addMessages(Message messages) {
	return messagesService.addMessage(messages);
}
@GET
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public Message getMessage(@PathParam("messageId")long id) {
	return messagesService.getMessage(id);
	
}

@PUT
@Path("/{messageId1}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message updateMessages(@PathParam("messageId1")long id,Message message) {
	message.setId(id);
	return messagesService.updateMessage(message);
}

@DELETE
@Path("/{messageId}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteMessage(@PathParam("messageId")long id) {
	messagesService.removeMessage(id);
	
}
	
}
