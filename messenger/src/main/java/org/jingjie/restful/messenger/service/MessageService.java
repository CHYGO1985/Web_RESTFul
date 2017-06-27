package org.jingjie.restful.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jingjie.restful.messenger.database.DatabaseClass;
import org.jingjie.restful.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L,  new Message(1, "Hello World!", "Jingjie"));
		messages.put(2L,  new Message(2, "Hello REST!", "Jingjie"));
	}

	// get all messages and return as a list
	public List<Message> getAllMessages() {
		
		return new ArrayList<Message>(messages.values());
	}
	
	// get a particular message with a given id
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	// add a message
	public Message addMessage(Message message) {
		
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	// update a message
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	// remove a message
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
