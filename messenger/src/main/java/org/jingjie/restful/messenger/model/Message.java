package org.jingjie.restful.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // tell the JSP the root for XML file
public class Message {

	private long id;
	private String messåge;
	private Date created;
	private String author;
	
	public Message() {
		
	}
	
	public Message(long id, String messåge, String author) {
		this.id = id;
		this.messåge = messåge;
		this.author = author;
		this.created = new Date();
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
}
