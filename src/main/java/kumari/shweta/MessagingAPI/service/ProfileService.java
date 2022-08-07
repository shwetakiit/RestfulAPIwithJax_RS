package kumari.shweta.MessagingAPI.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlType;

import kumari.shweta.MessagingAPI.Database.Databaseclass;
import kumari.shweta.MessagingAPI.model.Message;
import kumari.shweta.MessagingAPI.model.Profile;
@XmlType(name="")
public class ProfileService {
	
	public  Map<String,Profile> profiles=Databaseclass.getProfiles();

	public ProfileService() {
		profiles.put("skumari", new Profile(1,"shweta","skumari",new Date()));
	}
	
	  public List<Profile> getAllProfiles(){
			
			return new ArrayList<Profile>(profiles.values());
		}
/*     	
public static void main(String arg[]) {
	ProfileService po= new ProfileService();
	System.out.print("dshfdsf"+po.profiles);
}*/
}
