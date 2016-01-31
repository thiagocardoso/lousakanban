package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.junit.Test;

import com.google.common.collect.Maps;

public class UserTest {
	
	private static final String THIAGO = "thiago";
	private static final String THIAGO_CARDOSO = "Thiago Cardoso";
	private static final String EMAIL = "thiagocardoso.s@gmail.com";
	private static final String SENHA = "teste";

	@Test
	public void userWithLoginAndName() {
		final User user = User.from(THIAGO, THIAGO_CARDOSO, EMAIL, SENHA);
		assertNotNull(user);
		assertEquals(THIAGO_CARDOSO, user.getName());
		assertEquals(THIAGO, user.getLogin());
	}
	
	@Test
	public void twoEqualUsersWithLoginThiago() {
		final User user1 = User.from(THIAGO, THIAGO_CARDOSO, EMAIL, SENHA);
		final User user2 = User.from(THIAGO, THIAGO_CARDOSO, EMAIL, SENHA);
		assertNotNull(user1);
		assertNotNull(user2);
		assertEquals(user1, user2);
	}
	
	@Test
	public void insertUserInHashAndRetrieveWithAnotherInstance() {
		HashMap<User, String> map = Maps.newHashMap();
		
		map.put(User.from(THIAGO, THIAGO_CARDOSO, EMAIL, SENHA), "test");
		
		assertNotNull(map.get(User.from(THIAGO, THIAGO_CARDOSO, EMAIL, SENHA)));
		assertEquals("test", map.get(User.from(THIAGO, THIAGO_CARDOSO, EMAIL, SENHA)));
	}
	
	@Test
	public void validateUserToString() {
		final User user = User.from("test", "TEST", EMAIL, SENHA);
		assertEquals("User{login=test, name=TEST}", user.toString());
	}
}
