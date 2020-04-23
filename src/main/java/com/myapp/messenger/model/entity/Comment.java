package com.myapp.messenger.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comment {

	@Id
	@GenericGenerator(name = "comment_id_gen", strategy = "increment")
	@GeneratedValue(generator = "comment_id_gen")
	private Integer id;

	private String author;

	private Date createdOn;

	private String comment;

	public Comment() {

	}

	public Comment(String author, String comment) {
		this.author = author;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
