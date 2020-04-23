package com.myapp.messenger.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Message {
	@Id
	@GenericGenerator(strategy = "increment", name = "msg_id_generator")
	@GeneratedValue(generator = "msg_id_generator")
	private Integer id;

	private String message;

	private Date createdOn;

	private String author;

	public Message() {
	}

	public Message(String message, String author) {
		this.message = message;
		this.author = author;
		this.createdOn = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
