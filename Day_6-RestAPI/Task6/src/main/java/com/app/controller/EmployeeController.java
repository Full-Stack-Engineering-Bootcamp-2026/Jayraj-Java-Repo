package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
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
    public ResponseEntity<Employee> getById(@PathVariable int id){
    	Employee emp = service.findById(id);
    	
    	if(emp==null)
    		return ResponseEntity.status(400).build();
    
    	return ResponseEntity.ok(emp);
    }
    
    //POST
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee emp){
    	return ResponseEntity.status(200).body(service.save(emp));
    }
    
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable int id,@RequestBody Employee emp){
    	Employee updated = service.update(id, emp);
    	
    	if(updated == null) {
    		return ResponseEntity.status(400).build();
    	}
    	return ResponseEntity.ok(updated);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = service.delete(id);

        if (!deleted) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.noContent().build();
    }
    
    //Search by department
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchByDepartment(@RequestParam String department) {
        
        List<Employee> list = service.findByDepartment(department);
        
        if (list.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(list);
    }
    
    
    
    
    
}
