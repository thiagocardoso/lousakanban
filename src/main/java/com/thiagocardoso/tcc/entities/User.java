package com.thiagocardoso.tcc.entities;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String login;
	private String email;
	private String password;
	
	private List<Task> tasks = Lists.newLinkedList();

	private Team team;
	
	User(){
	}
	
	@PersistenceConstructor
	User(String id, String login, String name, String email, String password, List<Task> tasks) {
		this(id, login, name, email, password);
		this.tasks = tasks;
		
		for (Task task : tasks) {
			task.setUserLogin(this.login);
		}
	}
	
	User(String id, String login, String name, String email, String password) {
		this.id = id;
		this.login = login;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	

	public static User from(String login, String name, String email, String password) {
		return new User(null, login, name, email, password);
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public Team getTeam() {
		return this.team;		
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
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
			return Objects.equal(this.login, other.login);
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
