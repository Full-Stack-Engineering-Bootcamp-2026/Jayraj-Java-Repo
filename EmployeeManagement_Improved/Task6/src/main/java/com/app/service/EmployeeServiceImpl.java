package com.app.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.app.repository.DepartmentRepository;
import com.app.repository.EmployeeRepository;
import com.app.repository.ProjectRepository;

import lombok.AllArgsConstructor;

import com.app.dto.*;
import com.app.entity.Department;
import com.app.entity.Employee;
import com.app.entity.Project;
import com.app.exception.ResourceNotFoundException;




@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository repo;
	private final ProjectRepository projectRepo;
	private final DepartmentRepository departmentRepo;

	
	public EmployeeResponseDTO save(EmployeeRequestDTO dto) {

	    Department dept = departmentRepo.findById(dto.getDepartmentId())
	        .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

	    Employee emp = new Employee();
	    emp.setName(dto.getName());
	    emp.setEmail(dto.getEmail());
	    emp.setSalary(dto.getSalary());
	    emp.setAge(dto.getAge());
	    emp.setRole(dto.getRole());
	    emp.setPhone(dto.getPhone());
	    emp.setDepartment(dept);

	    Employee saved = repo.save(emp);

	    return mapToResponseDTO(saved);
	}
	
	public List<EmployeeResponseDTO> getAll() {

	    return repo.findAll()
	        .stream()
	        .map(this::mapToResponseDTO)
	        .toList();
	}
	
	public EmployeeResponseDTO getById(Integer id) {

	    Employee emp = repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

	    return mapToResponseDTO(emp);
	}
	
	
	public EmployeeResponseDTO update(Integer id, EmployeeRequestDTO dto) {

	    Employee emp = repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

	    Department dept = departmentRepo.findById(dto.getDepartmentId())
	        .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

	    emp.setName(dto.getName());
	    emp.setEmail(dto.getEmail());
	    emp.setSalary(dto.getSalary());
	    emp.setAge(dto.getAge());
	    emp.setRole(dto.getRole());
	    emp.setPhone(dto.getPhone());
	    emp.setDepartment(dept);

	    Employee updated = repo.save(emp);

	    return mapToResponseDTO(updated);
	}
	
	public void delete(Integer id) {
	    if (!repo.existsById(id)) {
	        throw new ResourceNotFoundException("Employee not found");
	    }
	    repo.deleteById(id);
	}
	
	public EmployeeResponseDTO assignProject(Integer empId, Integer projectId) {

	    Employee emp = repo.findById(empId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

	    Project proj = projectRepo.findById(projectId)
	        .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

	    if (emp.getProjects() == null) {
	        emp.setProjects(new ArrayList<>());
	    }

	    if (!emp.getProjects().contains(proj)) {
	        emp.getProjects().add(proj);
	    }

	    Employee saved = repo.save(emp);

	    return mapToResponseDTO(saved);
	}
	
	
	private EmployeeResponseDTO mapToResponseDTO(Employee emp) {

	    EmployeeResponseDTO dto = new EmployeeResponseDTO();

	    dto.setId(emp.getId());
	    dto.setName(emp.getName());
	    dto.setEmail(emp.getEmail());
	    dto.setRole(emp.getRole());

	    if (emp.getDepartment() != null) {
	        dto.setDepartmentName(emp.getDepartment().getName());
	    }

	    return dto;
	}
	

    

    
}
