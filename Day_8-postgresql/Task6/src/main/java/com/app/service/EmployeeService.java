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
        return repo.findById(id).orElse(null);
    }

    // SAVE
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    // UPDATE
    public Employee update(int id, Employee emp) {
        if (repo.existsById(id)) {
            emp.setId(id);
            return repo.save(emp);
        }
        return null;
    }

    // DELETE
    public boolean delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    
    //Search by department
    public List<Employee> findByDepartment(String department) {
        return repo.findByDepartmentIgnoreCase(department);
    }

    public List<Employee> filterEmployees(List<String> departments, Double minSalary) {

        List<Employee> all = repo.findAll();

        if ((departments == null || departments.isEmpty()) && minSalary == null) {
            return all;
        }

        List<Employee> result = new ArrayList<>();

        for(Employee emp : all) {

            // Department filter
            if (departments != null && !departments.isEmpty()) {
                if (!departments.contains(emp.getDepartment())) {
                    continue;
                }
            }

            // Salary filter
            if (minSalary != null && emp.getSalary() < minSalary) {
                continue;
            }

            result.add(emp);
        }

        return result;
    }
    
    
    
}
