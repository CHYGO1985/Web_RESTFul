package org.jingjie.restful.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jingjie.restful.messenger.model.Comment;
import org.jingjie.restful.messenger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = new HashMap<>();
	
	public CommentService() {
		
	}
	
	// get all comments that belong to a message
	public List<Comment> getAllComments(long messageId) {
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	// get a single comment that belongs to a message
	public Comment getComment(long messageId, long commentId) {
		
		return messages.get(messageId).getComments().get(commentId);
	}
	
	// update a comment of a given message
	public Comment updateComment(long messageId, Comment comment) {
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) return null;
		return comments.put(comment.getId(), comment);
	}
	
	// add a comment to a given message
	public Comment addComment(long messageId, Comment comment) {
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		return comments.put(comment.getId(), comment);
	}
	
	// delete a comment with a given message
	public Comment deleteComment(long messageId, long commentId) {
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

}
