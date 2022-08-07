package kumari.shweta.messageResource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import kumari.shweta.MessagingAPI.model.Profile;
import kumari.shweta.MessagingAPI.service.ProfileService;

@Path("profilecrud")
public class ProfileCrudOperationResource {

	ProfileService profileService= new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getAllProfiles(){
		List<Profile> list1=profileService.getAllProfiles();
		return list1;
	}
}
