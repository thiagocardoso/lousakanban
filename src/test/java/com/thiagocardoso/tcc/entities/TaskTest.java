package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {
	private static final String ANOTHER_LOGIN = "another";
	private static final String ANOTHER_NAME = "ANOTHER";
	private static final String TEST_LOGIN = "test";
	private static final String TEST_NAME = "TEST";
	private static final String TITLE_TASK_1 = "Task#1";

	@Test
	public void createTaskToUser() {
		final Task task = Task.toUser(User.from(TEST_LOGIN, TEST_NAME), TITLE_TASK_1);
		assertNotNull(task);
		assertEquals(TITLE_TASK_1, task.getTitle());
	}
	
	@Test
	public void verifyUserTasks() {
		assertEquals(User.from(TEST_LOGIN, TEST_NAME), Task.toUser(User.from(TEST_LOGIN, TEST_NAME), TITLE_TASK_1).getUser());
	}
	
	@Test
	public void createTaskToUserAndAssignToAnother(){
		final User user1 = User.from(TEST_LOGIN, TEST_NAME);
		final User user2 = User.from(ANOTHER_LOGIN, ANOTHER_NAME);
		final Task task = Task.toUser(user1, TITLE_TASK_1);
		assertEquals(user2, task.assign(user2).getUser());
	}
	
	@Test
	public void twoEqualTasksToSameUser() {
		final User user1 = User.from(TEST_LOGIN, TEST_NAME);
		final Task task1 = Task.toUser(user1, TITLE_TASK_1);
		final Task task2 = Task.toUser(user1, TITLE_TASK_1);
		assertEquals(task1, task2);
	}
	
	@Test
	public void twoEqualTasksToDifferentUser() {
		final User user1 = User.from(TEST_LOGIN, TEST_NAME);
		final User user2 = User.from(ANOTHER_LOGIN, ANOTHER_NAME);
		final Task task1 = Task.toUser(user1, TITLE_TASK_1);
		final Task task2 = Task.toUser(user2, TITLE_TASK_1);
		assertNotEquals(task1, task2);
	}
	
}
