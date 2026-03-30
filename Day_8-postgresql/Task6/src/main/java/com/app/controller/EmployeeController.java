package com.app.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@RestController
@Validated
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService service;

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
    	
    	if(emp==null)
    		return ResponseEntity.status(404).build();
    
    	return ResponseEntity.ok(emp);
    }
    
    //POST
    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee emp){
    	return ResponseEntity.status(201).body(service.save(emp));
    }
    
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(
    		@PathVariable 
    		@Min(value =1 , message="ID must be greater than >0")
    		int id,
    		@Valid @RequestBody Employee emp){
    	Employee updated = service.update(id, emp);
    	
    	if(updated == null) {
    		return ResponseEntity.status(404).build();
    	}
    	return ResponseEntity.ok(updated);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable 
            @Min(value = 1, message = "ID must be > 0")
            int id) {

        boolean deleted = service.delete(id);

        if (!deleted) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.noContent().build();
    }
    
    //Search by department
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchByDepartment(
            @RequestParam 
            @NotBlank(message = "Department cannot be empty")
            String department) {

        List<Employee> list = service.findByDepartment(department);

        if (list.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<Employee>> filterEmployees(
            @RequestParam(required = false) 
            @Size(max = 5, message = "Max 5 departments allowed")
            List<String> department,

            @RequestParam(required = false)
            @Min(value = 1000, message = "Min salary must be >= 1000")
            Double minSalary) {

        return ResponseEntity.ok(
                service.filterEmployees(department, minSalary)
        );
    }
    
    
    
    
    
}
