package kumari.shweta.messageResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectparam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InjectParamResource {
	
	//http://localhost:9998/MessagingAPI/webapi/injectparam/annotations;param=shweta

	@GET
	@Path("annotations")
	public String getParamUsingAnnotation(@MatrixParam("param")String matrixparam,
			@HeaderParam("authSessionID") String header,
			@CookieParam("cookieName") String mycookie) {
		return "matrix param :"+matrixparam+"Header param is "+header+" Cookie value"+mycookie;
	}
	
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders headers) {
		String path=uriInfo.getAbsolutePath().toString();
		System.out.println("Cookies value"+headers.getCookies().get("testCookie"));
		return "Absoule path of API "+path+ "and headers data is "+headers.getCookies();
	}
}
