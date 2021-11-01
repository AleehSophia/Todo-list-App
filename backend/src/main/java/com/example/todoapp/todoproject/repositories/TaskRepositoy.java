package com.example.todoapp.todoproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.todoproject.entities.Task;

@Repository
public interface TaskRepositoy extends JpaRepository<Task, Long>{

}
