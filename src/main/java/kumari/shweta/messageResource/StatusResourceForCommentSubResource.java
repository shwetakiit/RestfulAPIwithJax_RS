/**
 * 
 */
package kumari.shweta.messageResource;

import javax.ws.rs.Path;



/**
 * @author Shweta kumari
 *
 */

@Path("/status")
public class StatusResourceForCommentSubResource {
	
	@Path("/{statusId}/statuscomment")
	public CommentReSource commentForStatus() {
		return new CommentReSource();
		
	}
	
	

}
