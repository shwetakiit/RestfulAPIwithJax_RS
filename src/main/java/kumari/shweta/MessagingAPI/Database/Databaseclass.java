package kumari.shweta.MessagingAPI.Database;
/**
 * @author Shweta Kumari
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kumari.shweta.MessagingAPI.model.Comment;
import kumari.shweta.MessagingAPI.model.FaceBookStatus;
import kumari.shweta.MessagingAPI.model.Message;
import kumari.shweta.MessagingAPI.model.Profile;
public class Databaseclass {

	public static	Map<Long,Message> messages= new HashMap<Long,Message>();
	
	public static Map<String,Profile> profiles= new HashMap<String,Profile>();
	public static Map<Integer, FaceBookStatus> statuses = new HashMap<>();
   	public static Map<Integer,Comment> comments = new HashMap<Integer, Comment>();
	public static Map<Long,Message>	getMessages(){
		return messages;
	}
	public static Map<String,Profile> getProfiles(){
	
		return profiles;
	}
	public static Map<Integer,FaceBookStatus> getStatus(){
		return statuses;
	}
	public static Map<Integer,Comment> getComments(){
		return comments;
	}
}
