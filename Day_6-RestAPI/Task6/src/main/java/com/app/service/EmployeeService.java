package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.model.Employee;

@Service
public class EmployeeService {
	
	private Map<Integer, Employee> employeeMap = new HashMap<>();
   
    public EmployeeService() {
        employeeMap.put(1, new Employee(1, "Raj", "IT", "raj@gmail.com", 50000));
        employeeMap.put(2, new Employee(2, "Amit", "HR", "amit@gmail.com", 40000));
        employeeMap.put(3, new Employee(3, "Neha", "Finance", "neha@gmail.com", 55000));
        employeeMap.put(4, new Employee(4, "Priya", "IT", "priya@gmail.com", 60000));
        employeeMap.put(5, new Employee(5, "Karan", "Sales", "karan@gmail.com", 45000));
    }
    
    //GET All
    public List<Employee> findAll(){
    	return new ArrayList<>(employeeMap.values()); 
    }
    
    //Get by ID
    public Employee findById(int id) {
    	return employeeMap.get(id);
    }
    
    //Save (Post)
    public Employee save(Employee emp) {
    	employeeMap.put(emp.getId(), emp);
    	return emp;
    }
    
    //Update (Put)
    public Employee update(int id,Employee emp) {
    	if(employeeMap.containsKey(id)) {
    		emp.setId(id);
    		employeeMap.put(id, emp);
    		return emp;
    	}
    	return null;
    }
    
    //Delete 
    public boolean delete(int id) {
    	if(employeeMap.containsKey(id)) {
    		employeeMap.remove(id);
    		return true;
    	}
    	return false;
    }
    
    //Search by department
    public List<Employee> findByDepartment(String department){
    	List<Employee> result = new ArrayList<>();
    	
    	for(Employee emp : employeeMap.values()) {
    		if(emp.getDepartment().equalsIgnoreCase(department))
    			result.add(emp);
    	}
    	return result;
    }
    
    
    
}
