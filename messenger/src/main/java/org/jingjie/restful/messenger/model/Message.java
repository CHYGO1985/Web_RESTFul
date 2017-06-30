package org.jingjie.restful.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The class is the model for massages which contains: 
 * 1) message id; 
 * 2) message content;
 * 3) message created date;
 * 4) message author;
 * 5) comments of the message;
 * 6) hyperlinks of the message.
 * 
 * @author jingjiejiang
 * @Jun 27, 2017
 */
@XmlRootElement // tell the JSP the root for XML file
public class Message {

	private long id;
	private String messåge;
	private Date created;
	private String author;
	private Map<Long, Comment> comments; 
	private List<Link> links;
	
	public Message() {
		comments = new HashMap<>();
		links = new ArrayList<>();
	}
	
	public Message(long id, String messåge, String author) {
		this.id = id;
		this.messåge = messåge;
		this.author = author;
		this.created = new Date();
		comments = new HashMap<>();
		links = new ArrayList<>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessåge() {
		return messåge;
	}
	public void setMessåge(String messåge) {
		this.messåge = messåge;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient 
	// the annotation is used to ignore comments when user need to show info of a message
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url, String rel) {
		Link link = new Link(url, rel);
		links.add(link);
	}
}
