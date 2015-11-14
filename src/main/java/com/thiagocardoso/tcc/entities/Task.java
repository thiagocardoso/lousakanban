package com.thiagocardoso.tcc.entities;

public class Task {

	private User user;

	Task(User user){
		this.user = user;
		
	}
	
	public static Task toUser(User user) {
		return new Task(user);
	}

	public User getUser() {
		return this.user;
	}

	public Task assign(User user) {
		this.user = user;
		return this;
	}

}
