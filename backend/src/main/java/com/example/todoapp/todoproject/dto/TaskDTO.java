package com.example.todoapp.todoproject.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.todoapp.todoproject.entities.Task;

public class TaskDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	private String status;
	private String description;
	private LocalDate date;
	
	public TaskDTO() {
	}

	public TaskDTO(Long id, String name, String status, String description, LocalDate date) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
		this.date = date;
	}
	
	public TaskDTO (Task entity) {
		id = entity.getId();
		name = entity.getName();
		status = entity.getStatus();
		description = entity.getDescription();
		date = entity.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
