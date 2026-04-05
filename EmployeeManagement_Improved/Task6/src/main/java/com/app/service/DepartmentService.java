package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private DepartmentRepository repo;

	public DepartmentService(DepartmentRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Department> findAll(){
		return repo.findAll();
	}
	
	
	public Department findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Department not Found"));
	}
	
	
	public Department save(Department dept) {
		return repo.save(dept);
	}
	
	
	public Department update(Integer id, Department dept) {
		if(!repo.existsById(id))
			throw new RuntimeException("Department not Found");
		dept.setId(id);
		
		return repo.save(dept);
	}
	
	
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        repo.deleteById(id);
    }
	
}
