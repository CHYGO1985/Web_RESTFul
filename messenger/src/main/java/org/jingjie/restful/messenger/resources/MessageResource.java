package org.jingjie.restful.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.jingjie.restful.messenger.model.Message;
import org.jingjie.restful.messenger.service.MessageService;

/**
 *
 * The REST APIs for get and editing messages.
 * 
 * @author jingjiejiang
 * @history
 * 1. Jun 27, 2017
 */
@Path("/messages")
//because it is a method consumes json, so use Consumes annotation to specify the request body format
@Consumes(MediaType.APPLICATION_JSON)
// support multi types
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {
	
	MessageService messageService = new MessageService();

	/*
	@GET // GET annotation : map HTTP methods to java methods
	@Produces(MediaType.APPLICATION_XML) // Produces annotation: the response data type
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}") // this is to mao messageId in Message
	@Produces(MediaType.APPLICATION_XML)
	// @PathParam annotate that "messageId" is a parameter
	// messageId is converted to long by jersey
	public Message getMessage(@PathParam("messageId") long messageId) {
		
		return messageService.getMessage(messageId);
	}
	*/
	
	@GET // GET annotation : map HTTP methods to java methods
	public List<Message> getMessages(@QueryParam("year") int year,
					@QueryParam("offset") int offset, @QueryParam("size") int size) {
		
		if (year > 0) return messageService.getAllMessagesByYear(year);
		if (offset >= 0 && size > 0) return messageService.getAllMessageByPage(offset, size);
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}") // this is to map messageId in Message
	// @PathParam annotate that "messageId" is a parameter
	// messageId is converted to long by jersey
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		
		Message message = messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo, messageId), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComment(uriInfo, message), "comment");
		return message;
	}
	
	public String getUriForComment(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()	// get http://localhost:1080/messenger/webapi/
				.path(MessageResource.class) // get /messages
				.path(MessageResource.class, "getCommentResource") // get sub resrouce class + method
				.path(CommentResource.class) // get /commemnts
				.resolveTemplate("messageId", message.getId()) // get the argument @Path("/{messageId}/comments")
				.build();
		return uri.toString();
		
	}
	
	public String getUriForSelf(UriInfo uriInfo, long messageId) {
		URI uri = uriInfo.getBaseUriBuilder()	// get http://localhost:1080/messenger/webapi/
				.path(MessageResource.class) // get /messages as @Path("/messages")
				.path(Long.toString(messageId)) // get messageId @Path("/{messageId}")
				.build();
		return uri.toString();
	}
	
	public String getUriForProfile(UriInfo uriInfo, Message message) {
		
		URI uri = uriInfo.getBaseUriBuilder()
							.path(ProfileResource.class)
							.path(message.getAuthor()) // get profileName
							.build();
		return uri.toString();
	}
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}") // this is to map messageId in Message
	// Jersey will convert the parameter into an object of Message
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void delMessage(@PathParam("messageId") long messageId) {
		messageService.removeMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
}
