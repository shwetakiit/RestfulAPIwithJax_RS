package kumari.shweta.MessagingAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kumari.shweta.MessagingAPI.Database.Databaseclass;
import kumari.shweta.MessagingAPI.model.Message;

public class MessagesService {

	private Map<Long,Message> messages=Databaseclass.getMessages();
	
	public  MessagesService() {
		messages.put(1L, new Message(1,"Life is beautiful","Will"));
		messages.put(2L, new Message(2,"Just Chill","Peter"));
		
	}
   public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
		
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}


