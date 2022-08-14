package kumari.shweta.messageResource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommenResource {

	@GET
	public String test() {
		return "New sub resource !!!";
	}
	
	//get with comment id of subresource 
	
	/*@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") int comment) {
		
		return "Method return commentId "+comment;
		
	}
	*/
	
	//Get message id of parent resource
	@GET
	@Path("/{commentId}")
	public String test3(@PathParam("commentId") int commentId,@PathParam("messageId")long   messageId) {
		return "Method to return comment id"+commentId+" and Message id is "+messageId;
	}
	
}
