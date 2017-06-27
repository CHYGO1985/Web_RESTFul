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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jingjie.restful.messenger.model.Message;
import org.jingjie.restful.messenger.service.MessageService;

@Path("messages")
//because it is a method consumes json, so use Consumes annotation to specify the request body format
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
	public Message getMessage(@PathParam("messageId") long messageId) {
		
		return messageService.getMessage(messageId);
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
	
}
