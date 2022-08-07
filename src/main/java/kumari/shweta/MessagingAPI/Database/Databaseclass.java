package kumari.shweta.MessagingAPI.Database;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import kumari.shweta.MessagingAPI.model.Message;
import kumari.shweta.MessagingAPI.model.Profile;
public class Databaseclass {

	public static	Map<Long,Message> messages= new HashMap<Long,Message>();
	
	public static Map<String,Profile> profiles= new HashMap<String,Profile>();
	public static Map<Long,Message>	getMessages(){
		return messages;
	}
	
	public static Map<String,Profile> getProfiles(){
		profiles.put("skumari", new Profile(1,"shweta","skumari",new Date()));
		return profiles;
	}
}
