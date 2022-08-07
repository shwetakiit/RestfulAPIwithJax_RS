package kumari.shweta.MessagingAPI.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	private int id;
	private String Name;
	private String profileName;
	private Date created ;
	

	public Profile() {
	
	}
	public Profile(int id, String name, String profileName, Date created) {
	
		this.id = id;
		Name = name;
		this.profileName = profileName;
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
