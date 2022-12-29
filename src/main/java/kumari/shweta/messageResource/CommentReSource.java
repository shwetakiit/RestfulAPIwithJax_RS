package kumari.shweta.messageResource;

/**
 * @author Shweta Kumari
 */

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

/*
 * This resource is subresource for Comments of FacebookStatus url 
 * Find List of Comments available for Status 
 * Remove comment from status 
 * Add comment on Status 
 * Edit comment on Status
 * 
 */
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kumari.shweta.MessagingAPI.model.Comment;
import kumari.shweta.MessagingAPI.model.FaceBookStatus;
import kumari.shweta.MessagingAPI.service.FaceBookStatusService;

@Path("/")
public class CommentReSource {
	FaceBookStatusService statusService = new FaceBookStatusService();

	@GET
	public List<Comment> getAllComments(@PathParam("statusId") Integer statusId) {
		return statusService.getComments(statusId);
	}

	@GET
	@Path("/{statusCommentId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String commentForStatus(@PathParam("statusCommentId") Integer commentId,
			@PathParam("statusId") Integer statusId) {
		Comment comment = statusService.getComment(statusId, commentId);
		return comment.toString();

	}

	/*
	 * URI format
	 * http://localhost:9998/MessagingAPI/webapi/status/1/statuscomment/allstatus/
	 */

	@GET
	@Path("/{allstatus}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FaceBookStatus> getAllFaceBookStatus() {
		return statusService.getAllFaceBookStatus();
	}

	// Post request with URI format
	// :http://localhost:9998/MessagingAPI/webapi/status/1/statuscomment/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public FaceBookStatus addCommentForBookStatus(@PathParam("statusId") int statusId, Comment comment) {
		return statusService.addComment(statusId, comment);
	}

	// DELETE URI format :http://localhost:9998/MessagingAPI/webapi/status/1/statuscomment/1
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public FaceBookStatus removeCommentFaceBookStatus(@PathParam("statusId") int statusId,
			@PathParam("commentId") int commentID) {
		return statusService.removeComment(statusId, commentID);
	}

}
