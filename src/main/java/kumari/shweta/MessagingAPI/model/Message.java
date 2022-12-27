package kumari.shweta.MessagingAPI.model;
/**
 * @author Shweta Kumari
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;

	private String author;
	
	List<Link> links= new ArrayList<>();
	List<Profile> profiles= new ArrayList<>();
	
	/*
	 * No -arg constructor is mandatory - If we getting result in json/xml
	 * --required no -arg constructor to create Object
	 */
	
	public Message() {
		
	}
	public Message(long id, String message, String author) {
		
		this.id = id;
		this.message = message;
		
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url,String rel) {
		
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
		
	}
	
	public void addProfile(String url,String rel) {
	Profile profile=new Profile();
	profile.setName(url);
	profile.setProfileName("self");
	profile.setId(11);
	profile.setCreated(new Date());
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", author=" + author + ", links=" + links + ", profiles="
				+ profiles + "]";
	}
	
	
	
	
}
