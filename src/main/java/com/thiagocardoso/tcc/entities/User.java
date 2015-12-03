package com.thiagocardoso.tcc.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@Document
public class User {

	@Id
	private String id;
	private final String name;
	private final String login;
	private final List<Task> tasks = Lists.newLinkedList();

	private Team team;
	
	User(String login, String name) {
		this.login = login;
		this.name = name;
	}

	public Object getName() {
		return name;
	}

	public static User from(String login, String name) {
		return new User(login, name);
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public Team getTeam() {
		return this.team;		
	}
	
	public List<Task> getTasks() {
		return this.tasks;
	}
	
	public User addTask(Task task) {
		checkNotNull(task);
		this.tasks.add(task);
		return this;
	}
	
	public void removeTask(Task task) {
		if(tasks.contains(task))
			this.tasks.remove(task);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User){
			User other = (User)obj;
			return Objects.equal(this.login, this.login) 
				&& Objects.equal(this.name, other.name);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(login, name);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("login", this.login).add("name", this.name).toString();
	}

}
