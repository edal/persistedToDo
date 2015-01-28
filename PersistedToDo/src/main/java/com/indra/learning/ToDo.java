package com.indra.learning;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Clase que representa una tarea a realizar.
 * 
 * @author ealcalal
 *
 */
@Entity
public class ToDo {
	@Id
	@GeneratedValue
	private Long id;
	private String taskDescription;
	private boolean completed;
	private Date creationDate;
	private Date finished;

	public ToDo() {
		this.creationDate = new Date();
	}

	/**
	 * Constructor principal.
	 * 
	 * @param task
	 *            Descripcion de la tarea
	 * @param completed
	 *            Indicador de finalización de la tarea
	 * @param added
	 *            Fecha de creacion de la tarea
	 */
	public ToDo(String taskDescription, boolean completed, Date creationDate) {
		this.taskDescription = taskDescription;
		this.completed = completed;
		this.creationDate = creationDate;
	}

	/**
	 * Constructor simplificado. La fecha de creación de la tarea se establece
	 * desde la fecha del sistema. Por defecto se indica como no finalizada
	 * 
	 * @param task
	 *            Descripcion de la tarea
	 */
	public ToDo(String taskDescription) {
		this.taskDescription = taskDescription;
		this.creationDate = new Date();
		this.completed = false;
	}

	@Override
	public String toString() {
		return creationDate + ": " + this.getTaskDescription();
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getFinished() {
		return finished;
	}

	public void setFinished(Date finished) {
		this.finished = finished;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completed ? 1231 : 1237);
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((finished == null) ? 0 : finished.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((taskDescription == null) ? 0 : taskDescription.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ToDo))
			return false;
		ToDo other = (ToDo) obj;
		if (completed != other.completed)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (finished == null) {
			if (other.finished != null)
				return false;
		} else if (!finished.equals(other.finished))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taskDescription == null) {
			if (other.taskDescription != null)
				return false;
		} else if (!taskDescription.equals(other.taskDescription))
			return false;
		return true;
	}
}
