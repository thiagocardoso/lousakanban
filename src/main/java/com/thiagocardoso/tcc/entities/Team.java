package com.thiagocardoso.tcc.entities;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.List;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class Team {

	private final String name;
	private final List<User> users = Lists.newLinkedList();

	Team() {
		this("");
	}
	
	public Team(String name) {
		checkNotNull(name);
		checkArgument(isNotEmpty(name));
		this.name = name;
	}

	public static Team withName(String name) {
		return new Team(name);
	}

	public String getName() {
		return name;
	}
	
	public List<User> getUsers() {
		return ImmutableList.copyOf(users);
	}
	
	public Team addUser(User user) {
		checkNotNull(user);
		this.users.add(user);
		return this;
	}
	
	public Team removeUser(User user) {
		checkNotNull(user);
		this.users.remove(user);
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Team){
			Team other = (Team)obj;
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

	public int userCount() {
		return this.users.size();
	}

}
