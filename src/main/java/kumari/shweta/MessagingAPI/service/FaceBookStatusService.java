package kumari.shweta.MessagingAPI.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.httpclient.NTCredentials;

import kumari.shweta.MessagingAPI.Database.Databaseclass;
import kumari.shweta.MessagingAPI.model.Comment;
import kumari.shweta.MessagingAPI.model.FaceBookStatus;

/**
 * @author Shweta Kumari
 * @param <E>
 */

public class FaceBookStatusService {
	
	private Map<Integer, FaceBookStatus> status= Databaseclass.getStatus();
	private Map<Integer,Comment> comments =Databaseclass.getComments();

	public FaceBookStatusService() {
		comments.put(1, new Comment(1, "Awesome","Shweta", new Date()));
		status.put(1, new FaceBookStatus(1,"Be true to yourself",new Date(),"Alica", comments));
		
	}
	

	public List<Comment> getComments(Integer statusId){
		if(status.get(statusId)==null) {
			return null;
		} else {
			Map<Integer, Comment> comments=status.get(statusId).getComments();
			return new ArrayList<Comment>(comments.values());
		}
		
		
	}
	
	public Comment getComment(Integer statusId,Integer commentId) {
    Comment comment=status.get(statusId).getComments().get(commentId);
    return comment;
	}
	
	public List<FaceBookStatus> getAllFaceBookStatus() {
	return new ArrayList<FaceBookStatus>(status.values());
	}
	
	public FaceBookStatus addComment(int statusId,Comment comment) {
		if(status.get(statusId)==null) {
			return null;
		} else {
			FaceBookStatus faceBookStatus= status.get(statusId);
			Map<Integer,Comment> coMap=faceBookStatus.getComments();
			comment.setCommentId(coMap.size()+1);
			comment.setCreateDate(new Date());
			coMap.put(coMap.size()+1, comment);
			
			return faceBookStatus;
			
		}
	}
	
	public FaceBookStatus removeComment(int statusId,Integer commentId ) {
		if(status.get(statusId)==null ) {
			return null;
		} else {
		Map<Integer, Comment> coMap= status.get(statusId).getComments();
			coMap.remove(commentId);
			return status.get(statusId);
			
		}
		
		
	}

}
