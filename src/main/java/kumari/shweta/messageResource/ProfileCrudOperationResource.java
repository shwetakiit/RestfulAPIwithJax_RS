package kumari.shweta.messageResource;
/**
 * @author Shweta Kumari
 */

import java.util.List;

import javax.ws.rs.BeanParam;
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
	public List<Profile> getAllProfiles(@BeanParam MessageFilterBean filterBean) {
		List<Profile> profileList;
		if (filterBean.getYear() > 0) {
			profileList = profileService.getAllProfileForYear(filterBean.getYear());

		} else if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			profileList = profileService.getAllMessagePaginated(filterBean.getStart(), filterBean.getSize());
		} else {
			profileList = profileService.getAllProfiles();
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
