package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Employee;
import com.app.entity.Task;
import com.app.repository.EmployeeRepository;
import com.app.repository.TaskRepository;

@Service
public class TaskService {
	
	private TaskRepository repo;
	private EmployeeRepository employeeRepo;

	
	
	public TaskService(TaskRepository repo, EmployeeRepository employeeRepo) {
		super();
		this.repo = repo;
		this.employeeRepo = employeeRepo;
	}

	//Get All
	public List<Task> findAll() {
	    return repo.findAll();
	}
	
	//Get By ID
	public Task findById(Integer id) {
	    return repo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Task not found"));
	}
	
	//Save
	public Task save(Task task) {

	    if (task.getEmployee() == null || task.getEmployee().getId() == null) {
	        throw new RuntimeException("Employee is required");
	    }

	    Integer empId = task.getEmployee().getId();

	    Employee emp = employeeRepo.findById(empId)
	        .orElseThrow(() -> new RuntimeException("Employee not found"));

	    task.setEmployee(emp);

	    return repo.save(task);
	}
	
	//Update
	public Task update(Integer id, Task task) {

	    if (!repo.existsById(id)) {
	        throw new RuntimeException("Task not found");
	    }

	    if (task.getEmployee() == null || task.getEmployee().getId() == null) {
	        throw new RuntimeException("Employee is required");
	    }

	    Integer empId = task.getEmployee().getId();

	    Employee emp = employeeRepo.findById(empId)
	        .orElseThrow(() -> new RuntimeException("Employee not found"));

	    task.setId(id);
	    task.setEmployee(emp);

	    return repo.save(task);
	}
	
	//Delete
	public void delete(Integer id) {
	    if (!repo.existsById(id)) {
	        throw new RuntimeException("Task not found");
	    }
	    	repo.deleteById(id);
	}
	
	

}
