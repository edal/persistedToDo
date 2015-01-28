package com.indra.learning;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class ToDoTest {

	@Test
	public void testConstructors() {
		Date creationDate = new Date();
		String taskDesc = "Descripcion de la tarea";

		ToDo task = new ToDo(taskDesc, false, creationDate);

		assertEquals(taskDesc, task.getTaskDescription());
		assertEquals(creationDate, task.getCreationDate());
		assertEquals(false, task.isCompleted());

		task.setTaskDescription(taskDesc);
		assertEquals(taskDesc, task.getTaskDescription());

		task.setFinished(creationDate);
		assertEquals(creationDate, task.getFinished());

		task.setCompleted(true);
		assertEquals(true, task.isCompleted());

		ToDo t2 = new ToDo(taskDesc);
		assertEquals(taskDesc, t2.getTaskDescription());

		// Validamos que la representación en texto del objeto contenga la
		// descripcion
		assertEquals(
				task.toString().indexOf(task.getTaskDescription().toString()) != -1,
				true);
	}
}
