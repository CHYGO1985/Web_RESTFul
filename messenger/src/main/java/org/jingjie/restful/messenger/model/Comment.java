package org.jingjie.restful.messenger.model;

import java.util.Date;

/**
 * 
 * The class represents the model of comments. The fields include:
 * 1) comment id;
 * 2) contents of a comment;
 * 3) created date of a comment;
 * 4) author of a comment.
 * 
 * @author jingjiejiang
 * @history 
 * 1. Jun 30, 2017
 */
public class Comment {
	
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public Comment() {
		
	}
	
	public Comment(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
