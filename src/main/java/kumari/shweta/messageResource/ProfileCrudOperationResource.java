package kumari.shweta.messageResource;
/**
 * @author Shweta Kumari
 */

import java.util.List;

import javax.validation.Path.ReturnValueNode;
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
	
	
	//If we don't pass any query param for "year" default value will be zero 
	
	/*
	 * http://localhost:9998/MessagingAPI/webapi/profilecrud?year=2015
	 * http://localhost:9998/MessagingAPI/webapi/profilecrud?start=0&size=2
	 */	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfileWithFiltertion(@QueryParam("year") int yr,
			                                         @QueryParam("start") int start,
			                                         @QueryParam("size") int size){
		if(yr>0) {
			return profileService.getAllProfileForYear(yr);
		} else if(start>=0 && size>0){
			return profileService.getAllMessagePaginated(start,size);
		} else {
			return profileService.getAllProfiles();
		}
	}
	
	
	/*
	 * [[FATAL] A resource model has ambiguous (sub-)resource method for HTTP method
	 * GET and input mime-types as defined by"@Consumes" and "@Produces" annotations
	 * at Java methods public java.util.List
	 * kumari.shweta.messageResource.ProfileCrudOperationResource.
	 * getAllProfileWithFiltertion(int) and public java.util.List
	 * kumari.shweta.messageResource.ProfileCrudOperationResource.getAllProfiles(
	 * kumari.shweta.messageResource.MessageFilterBean) at matching regular
	 * expression /profilecrud. These two methods produces and consumes exactly the
	 * same mime-types and therefore their invocation as a resource methods will
	 * always fail.;
	 * source='org.glassfish.jersey.server.model.RuntimeResource@61aa6300']
	 * 
	 * Avaoid this ambigous issue change url of getAllProfiles
	 */
	
	
	//http://localhost:9998/MessagingAPI/webapi/profilecrud/profiles?year=2015
	//http://localhost:9998/MessagingAPI/webapi/profilecrud/profiles?year=2015
	@GET
	@Path("/profiles")
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
