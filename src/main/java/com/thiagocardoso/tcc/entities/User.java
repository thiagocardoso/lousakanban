package com.thiagocardoso.tcc.entities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class User {

	private final String name;

	User(String name) {
		this.name = name;
	}

	public Object getName() {
		return name;
	}

	public static User from(String name) {
		return new User(name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User){
			User other = (User)obj;
			return Objects.equal(this.name, other.name);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("name", this.name).toString();
	}
}
