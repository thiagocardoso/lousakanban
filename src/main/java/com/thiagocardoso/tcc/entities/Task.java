package com.thiagocardoso.tcc.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;

import com.google.common.base.Preconditions;

import jersey.repackaged.com.google.common.base.Objects;

public class Task {

	public static class Builder {
		private String title;
		
		private String description;
		
		private Date createdAt = new Date();
		
		private Date updatedAt = new Date();
		
		Builder(String title) {
			Preconditions.checkNotNull(title);
			this.title = title;
		}
		
		public static Builder of(String title) {
			return new Builder(title);
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Task build() {
			return new Task(title, description, createdAt, updatedAt);
		}
	}
	
	private final String title;
	
	private final String description;
	
	private final Date createdAt;
	
	private final Date updatedAt;

	Task(String title, String description, Date createdAt, Date updatedAt){
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Task assign(User user) {
		checkNotNull(user);
		user.addTask(this);
		return this;
	}

	public String getTitle() {
		return this.title;
	}
	
	public User getUser() {
		return this.getUser();
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	
	public String getDescription() {
		return this.description;
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
