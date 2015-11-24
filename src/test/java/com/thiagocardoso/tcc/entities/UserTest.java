package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Test;

import com.google.common.collect.Maps;

public class UserTest {
	
	private static final String THIAGO = "thiago";
	private static final String THIAGO_CARDOSO = "Thiago Cardoso";

	@Test
	public void userWithLoginAndName() {
		final User user = User.from(THIAGO, THIAGO_CARDOSO);
		assertNotNull(user);
		assertEquals(THIAGO_CARDOSO, user.getName());
		assertEquals(THIAGO, user.getLogin());
	}
	
	@Test
	public void twoEqualUsersWithLoginThiago() {
		final User user1 = User.from(THIAGO, THIAGO_CARDOSO);
		final User user2 = User.from(THIAGO, THIAGO_CARDOSO);
		assertNotNull(user1);
		assertNotNull(user2);
		assertEquals(user1, user2);
	}
	
	@Test
	public void twoDifferentUsersWithLoginThiago() {
		final User user1 = User.from(THIAGO, THIAGO_CARDOSO);
		final User user2 = User.from(THIAGO, "Thiago Silveira");
		assertNotNull(user1);
		assertNotNull(user2);
		assertNotEquals(user1, user2);
	}
	
	@Test
	public void insertUserInHashAndRetrieveWithAnotherInstance() {
		HashMap<User, String> map = Maps.newHashMap();
		
		map.put(User.from(THIAGO, THIAGO_CARDOSO), "test");
		
		assertNotNull(map.get(User.from(THIAGO, THIAGO_CARDOSO)));
		assertEquals("test", map.get(User.from(THIAGO, THIAGO_CARDOSO)));
	}
	
	@Test
	public void validateUserToString() {
		final User user = User.from("test", "TEST");
		assertEquals("User{login=test, name=TEST}", user.toString());
	}
}
