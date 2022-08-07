package kumari.shweta.MessagingAPI.service;

/**
 * @author Shweta Kumari
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlType;

import kumari.shweta.MessagingAPI.Database.Databaseclass;
import kumari.shweta.MessagingAPI.model.Message;
import kumari.shweta.MessagingAPI.model.Profile;

public class ProfileService {

	public Map<String, Profile> profiles = Databaseclass.getProfiles();

	public ProfileService() {
		profiles.put("skumari", new Profile(1, "shweta", "skumari", new Date()));
	}

	public List<Profile> getAllProfiles() {

		return new ArrayList<Profile>(profiles.values());
	}
	
	public List<Profile> getAllProfileForYear(int year){
		List<Profile> profileList = new ArrayList<>();
		Calendar calendar=Calendar.getInstance();
		for(Profile profile : profiles.values()) {
		
			calendar.setTime(profile.getCreated());
			if( calendar.get(Calendar.YEAR)==year) {
				profileList.add(profile);
			}
		}
		return profileList;
	}
	
	//Pagination for rest api data
	public List<Profile> getAllMessagePaginated(int start,int size){
	List<Profile> profileList= new ArrayList<>(profiles.values());
	if(start+size>profileList.size()) {
		return new ArrayList<Profile>();
	}
	return profileList.subList(start, start+size);
	}
	
	public Profile addProfile(Profile profile) {
    profile.setId(profiles.size()+1);
	profiles.put(profile.getProfileName(), profile);
	return profile;
	
	}
	/*
	 * public static void main(String arg[]) { ProfileService po= new
	 * ProfileService(); System.out.print("dshfdsf"+po.profiles); }
	 */
}
