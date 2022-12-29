/**
 * 
 */
package kumari.shweta.MessagingAPI.model;

import java.util.Date;

/**
 * @author skumari
 *
 */
public class Comment {
	
	private int commentId;
	String commentMessage;
	String author;
	Date createDate;
	
	public Comment() {
		
	}
	public Comment(int commentId, String commentMessage, String author, Date createDate) {
		this.commentId = commentId;
		this.commentMessage = commentMessage;
		this.author = author;
		this.createDate = createDate;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentMessage() {
		return commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentMessage=" + commentMessage + ", author=" + author
				+ ", createDate=" + createDate + "]";
	}
	
	
}
