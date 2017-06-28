package org.jingjie.restful.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jingjie.restful.messenger.model.Comment;
import org.jingjie.restful.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService service = new CommentService();
	
	public CommentResource() {
		
	}
	
	// GET all comments of a given message
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return service.getAllComments(messageId);
	}
	
	// GET a comment of a given message
	@GET
	@Path("/{commentId}")
	// @PathParam("messageId") is to get param from parent resource (MessageRecource)
	public Comment getComment(@PathParam("messageId") long messageId, 
			@PathParam("commentId") long commentId) {
		return service.getComment(messageId, commentId);
	}
	
	// POST a comment to a given message
	@POST
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messsageId") long messsageId,
			@PathParam("commentId") long commentId, Comment comment) {
		return service.updateComment(messsageId, comment);
	}
	
	// PUT a comment of a given message
	@PUT
	public Comment addComment(@PathParam("messageId") long messageId
			, Comment comment) {
		return service.addComment(messageId, comment);
	}
	
	// DELETE a comment of a given message
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messgaeId") long messageId, 
				@PathParam("commentId") long commentId) {
		return service.deleteComment(messageId, commentId);
	}
}
