package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Test;

import com.google.common.collect.Maps;

public class UserTest {
	
	@Test
	public void userWithName() {
		final User user = User.from("thiago");
		assertNotNull(user);
		assertEquals("thiago", user.getName());
	}
	
	@Test
	public void twoEqualUsersrWithNameThiago() {
		final User user1 = User.from("thiago");
		final User user2 = User.from("thiago");
		assertNotNull(user1);
		assertNotNull(user2);
		assertEquals(user1, user2);
	}

	@Test
	public void insertUserInHashAndRetrieveWithAnotherInstance() {
		HashMap<User, String> map = Maps.newHashMap();
		
		map.put(new User("thiago"), "test");
		
		assertNotNull(map.get(new User("thiago")));
		assertEquals("test", map.get(new User("thiago")));
	}
	
	@Test
	public void validateUserToString() {
		final User user = new User("test");
		assertEquals("User{name=test}", user.toString());
	}
}
