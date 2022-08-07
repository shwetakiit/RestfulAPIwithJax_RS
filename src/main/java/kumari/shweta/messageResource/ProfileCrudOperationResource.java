package kumari.shweta.messageResource;
/**
 * @author Shweta Kumari
 */

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import kumari.shweta.MessagingAPI.model.Profile;
import kumari.shweta.MessagingAPI.service.ProfileService;

@Path("profilecrud")
public class ProfileCrudOperationResource {

	ProfileService profileService= new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles(@QueryParam("year")int year){
		List<Profile> profileList;
		if(year<=0) {
			profileList=profileService.getAllProfiles();
		
		} else {
			profileList=profileService.getAllProfileForYear(year);
		}
		return profileList;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		
		return profileService.addProfile(profile);
	}
	
	
}
