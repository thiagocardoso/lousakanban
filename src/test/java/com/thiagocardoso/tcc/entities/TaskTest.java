package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TaskTest {
	private static final String TITLE_TASK_1 = "Task#1";

	@Test
	public void createTaskToUser() {
		final Task task = Task.from(newUser(), TITLE_TASK_1, "");
		assertNotNull(task);
		assertEquals(TITLE_TASK_1, task.getTitle());
	}
	
	@Test
	public void twoEqualTasksToSameUser() {
		User user = newUser();
		final Task task1 = Task.from(user, TITLE_TASK_1, "");
		final Task task2 = Task.from(user, TITLE_TASK_1, "");
		assertEquals(task1, task2);
	}

	private User newUser() {
		return User.from("a", "a", "a", "");
	}
	
}
