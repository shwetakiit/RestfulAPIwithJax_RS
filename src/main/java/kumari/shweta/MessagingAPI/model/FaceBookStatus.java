package kumari.shweta.MessagingAPI.model;
/**
 * @author Shweta Kumari
 */

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceBookStatus {
	
	int id;
	String statusMessage;
	Date createDate;
	String author;
	Map<Integer,Comment> comments=new HashMap<>(); 
	public FaceBookStatus() {
		
	}
	
	
	public FaceBookStatus(int id, String statusMessage, Date createDate, String author,Map<Integer, Comment> m) {
        this.id = id;
		this.statusMessage = statusMessage;
		this.createDate = createDate;
		this.author = author;
		this.comments=m;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}


	public Map<Integer, Comment> getComments() {
		return comments;
	}


	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "FaceBookStatus [id=" + id + ", statusMessage=" + statusMessage + ", createDate=" + createDate
				+ ", author=" + author + ", comments=" + comments + "]";
	}

	
	

}
