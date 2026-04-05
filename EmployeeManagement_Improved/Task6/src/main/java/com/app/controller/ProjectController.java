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

import com.app.entity.Project;
import com.app.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	private final ProjectService service;

	public ProjectController(ProjectService service) {
		super();
		this.service = service;
	}
	
	
		@GetMapping
		public ResponseEntity<List<Project>> getAll(){
			return ResponseEntity.ok(service.findAll());
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<Project> getById(@PathVariable Integer id){
			return ResponseEntity.ok(service.findById(id));
		}
		
		
		@PostMapping
		public ResponseEntity<Project> create(@Valid @RequestBody Project project){
			Project saved = service.save(project);
			return new ResponseEntity<>(saved,HttpStatus.CREATED);
		}
		
		
		@PutMapping("/{id}")
		public ResponseEntity<Project> update(@PathVariable Integer id,@RequestBody Project project){
			Project updated = service.update(id, project);
			
			return ResponseEntity.ok(updated);
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.ok("Project deleted successfully");
		}
	
}
