package kumari.shweta.MessagingAPI.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import kumari.shweta.MessagingAPI.model.ErrorMessage;

@Provider 
//This annotation register this class with JAX-RS
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{
	

	@Override
public Response toResponse(DataNotFoundException exception) {
		
ErrorMessage erro= new ErrorMessage(exception.getMessage(),999,"go through restApi do");
		return Response.status(Status.NOT_FOUND).entity(erro).build();
	}

	

}
