package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Task;
import com.app.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService service;

	public TaskController(TaskService service) {
		super();
		this.service = service;
	}
	
		
		@GetMapping
		public ResponseEntity<List<Task>> getAll(){
			return ResponseEntity.ok(service.findAll());
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<Task> getById(@PathVariable int id){
			return ResponseEntity.ok(service.findById(id));
		}
		
		
		@PostMapping
		public ResponseEntity<Task> create(@Valid @RequestBody Task task){
			Task saved = service.save(task);
			return new ResponseEntity<>(saved,HttpStatus.CREATED);
		}
		
		
		@PutMapping("/{id}")
		public ResponseEntity<Task> update(@PathVariable int id,@RequestBody Task task){
			Task updated = service.update(id, task);
			
			return ResponseEntity.ok(updated);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> delete(@PathVariable int id){
			service.delete(id);
			return ResponseEntity.ok("Task deleted successfully");
		}

}
