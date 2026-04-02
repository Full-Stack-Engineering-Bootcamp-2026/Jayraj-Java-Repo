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

import com.app.entity.Department;
import com.app.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
		
	private final DepartmentService service;

	public DepartmentController(DepartmentService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Department>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Department> getById(@PathVariable int id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	
	@PostMapping
	public ResponseEntity<Department> create(@Valid @RequestBody Department dept){
		Department saved = service.save(dept);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> update(@PathVariable int id,@RequestBody Department dept){
		Department updated = service.update(id, dept);
		
		return ResponseEntity.ok(updated);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.ok("Department deleted successfully");
	}
	
}
