package com.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.app.repository.EmployeeRepository;
import com.app.repository.ProjectRepository;
import com.app.entity.Employee;
import com.app.entity.Project;


@Service
public class EmployeeService {
	
	private final EmployeeRepository repo;
	private final ProjectRepository projectRepo;

    public EmployeeService(EmployeeRepository repo , ProjectRepository projectRepository) {
        this.repo = repo;
        this.projectRepo = projectRepository;
    }
    
    
    public List<Employee> findAll() {
        return repo.findAll();
    }

    
    public Employee findById(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    
    public Employee update(int id, Employee emp) {
        if(!repo.existsById(id)) {
        	throw new RuntimeException("Employee not Found");
        }
        emp.setId(id);
        return repo.save(emp);
    }

    
    public void delete(int id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        repo.deleteById(id);
    }
    
    
    
    public Employee assignProject(int empId,int projectId) {
    	
    	//Get Employee
        Employee emp = repo.findById(empId)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        //Get Project
        Project proj = projectRepo.findById(projectId)
            .orElseThrow(() -> new RuntimeException("Project not found"));

        //Initialize list if null
        if (emp.getProjects() == null) {
            emp.setProjects(new ArrayList<>());
        }
        
        //Add Project
        emp.getProjects().add(proj);
        
        return repo.save(emp);
    }
    
}
