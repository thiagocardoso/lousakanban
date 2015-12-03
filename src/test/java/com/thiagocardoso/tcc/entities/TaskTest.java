package com.thiagocardoso.tcc.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TaskTest {
	private static final String TITLE_TASK_1 = "Task#1";

	@Test
	public void createTaskToUser() {
		final Task task = Task.Builder.of(TITLE_TASK_1).build();
		assertNotNull(task);
		assertEquals(TITLE_TASK_1, task.getTitle());
	}
	
	@Test
	public void twoEqualTasksToSameUser() {
		final Task task1 = Task.Builder.of(TITLE_TASK_1).build();
		final Task task2 = Task.Builder.of(TITLE_TASK_1).build();
		assertEquals(task1, task2);
	}
	
}
