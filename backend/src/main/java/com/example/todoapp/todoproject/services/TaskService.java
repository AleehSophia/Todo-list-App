package com.example.todoapp.todoproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todoapp.todoproject.dto.TaskDTO;
import com.example.todoapp.todoproject.entities.Task;
import com.example.todoapp.todoproject.repositories.TaskRepository;
import com.example.todoapp.todoproject.services.exceptions.ResourceNotFoundException;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Transactional(readOnly = true)
	public Page<TaskDTO> findAllPaged(Pageable pageable) {
		Page<Task> list = repository.findAll(pageable);
		return list.map(x -> new TaskDTO(x));
	}	
	
	@Transactional(readOnly = true)
	public TaskDTO findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		Task entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TaskDTO(entity);
	}
	
	@Transactional
	public TaskDTO insert(TaskDTO dto) {
		Task entity = new Task();
		entity.setName(dto.getName());
		entity.setStatus(dto.getStatus());
		entity.setDescription(dto.getDescription());
		entity.setDate(dto.getDate());
		entity = repository.save(entity);
		
		return new TaskDTO(entity);
	}
}