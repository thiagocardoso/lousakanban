package com.thiagocardoso.tcc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Document
public class User {

	@Id
	private String id;
	
	private final String name;
	private final String login;

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
