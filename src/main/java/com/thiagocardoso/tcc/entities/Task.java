package com.thiagocardoso.tcc.entities;

import jersey.repackaged.com.google.common.base.Objects;

public class Task {

	private User user;
	private String title;

	Task(User user, String title){
		this.user = user;
		this.title = title;
		
	}
	
	public static Task toUser(User user, String title) {
		return new Task(user, title);
	}

	public User getUser() {
		return this.user;
	}

	public Task assign(User user) {
		this.user = user;
		return this;
	}

	public String getTitle() {
		return this.title;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task) {
			final Task other = (Task)obj;
			return Objects.equal(this.user, other.user) && Objects.equal(this.title, other.title);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
