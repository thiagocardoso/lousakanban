package com.thiagocardoso.tcc.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.Objects;

@Document
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	
	private String description;
	
	private Date createdAt = new Date();
	
	private Date updatedAt = new Date();
	
	private Status status = Status.ABERTO;
	
	@Transient
	private User user;
	
	Task() {
	}
	
	Task(User user, String title, String description){
		this.title = title;
		this.description = description;
		this.assign(user);
	}
	
	public static Task from(User user, String title, String description) {
		return new Task(user, title, description);
	}
	
	public Task assign(User user) {
		checkNotNull(user);
		user.addTask(this);
		return this;
	}

	public String getTitle() {
		return this.title;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task) {
			final Task other = (Task)obj;
			return Objects.equal(this.title, other.title);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
