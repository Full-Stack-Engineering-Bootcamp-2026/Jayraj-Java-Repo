package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    
    //Get ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
    	return ResponseEntity.ok(service.findAll());
    }
    
    //Get By ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById
    		(@PathVariable
    		@Min(value = 1, message = "ID must be greater than 0")
    		int id){
    	Employee emp = service.findById(id);
    
    	return ResponseEntity.ok(emp);
    }
    
    //POST
    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee emp){
    	Employee saved = service.save(emp);
    	return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(
    		@PathVariable 
    		@Min(value =1 , message="ID must be greater than >0")
    		int id,
    		@Valid @RequestBody Employee emp){
    	Employee updated = service.update(id, emp);
    	
    	
    	return ResponseEntity.ok(updated);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable 
            @Min(value = 1, message = "ID must be > 0")
            int id) {
    		service.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    
   
    
    
    
    
    
}
