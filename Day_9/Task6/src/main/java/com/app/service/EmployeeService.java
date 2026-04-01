package com.app.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Service;

import com.app.repository.EmployeeRepository;
import com.app.entity.Employee;
@Service
public class EmployeeService {
	
	private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }
    
    // GET ALL
    public List<Employee> findAll() {
        return repo.findAll();
    }

    // GET BY ID
    public Employee findById(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not  found"));
    }

    // SAVE
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    // UPDATE
    public Employee update(int id, Employee emp) {
        if(!repo.existsById(id)) {
        	throw new RuntimeException("Employee not Found");
        }
        emp.setId(id);
        return repo.save(emp);
    }

    // DELETE
    public void delete(int id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        repo.deleteById(id);
    }
    
    
    
}
