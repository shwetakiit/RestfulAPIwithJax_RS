/**
 * 
 */
package kumari.shweta.messageResource;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * @author Shweta Kumari
 *
 */
@Path("/filedownload")
public class FileDownLoadWithRestApi {
	
	public static final String fileName="E:\\file.txt";	
	
	@GET
	@Path("/textfile")
	@Produces("text/plain")
	
	public Response getFile() {
		File file= new File(fileName);
		ResponseBuilder responseBuilder=Response.ok((Object)file);
		responseBuilder.header("Content-Disposition","attachment; filename=\"javatpoint_file.txt\"");
	   return responseBuilder.build();
	}
	

}
