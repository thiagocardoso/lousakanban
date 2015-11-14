package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {
	@Test
	public void createTaskToUser() {
		assertNotNull(Task.toUser(User.from("test")));
	}
	
	@Test
	public void verifyTaskUser() {
		assertEquals(User.from("test"), Task.toUser(User.from("test")).getUser());
	}
	
	@Test
	public void createTaskToUserAndAssignToAnother(){
		final User user1 = User.from("test");
		final User user2 = User.from("another");
		final Task task = Task.toUser(user1);
		assertEquals(user2, task.assign(user2).getUser());
	}
	
}
