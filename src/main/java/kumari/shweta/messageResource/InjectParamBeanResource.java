package kumari.shweta.messageResource;

import java.security.PublicKey;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import kumari.shweta.MessagingAPI.model.SearchParamBean;

@Path("beanParam")
public class InjectParamBeanResource {
//Inject pojo  using @BeanParam
	@GET
	@Produces()
	@Path("search")
public  Response  performSearchWithMultipleParamters(@BeanParam SearchParamBean beanParam ) {
	return Response.ok().entity(beanParam).type(MediaType.APPLICATION_JSON).build();
}
}
