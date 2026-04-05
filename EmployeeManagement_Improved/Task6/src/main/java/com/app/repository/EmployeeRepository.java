package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Override
	@EntityGraph(attributePaths = {"department", "projects"})
	 List<Employee> findAll();
	
	@Override
	@EntityGraph(attributePaths = {"department" ,"projects"})
	Optional<Employee> findById(Integer id);
	
}