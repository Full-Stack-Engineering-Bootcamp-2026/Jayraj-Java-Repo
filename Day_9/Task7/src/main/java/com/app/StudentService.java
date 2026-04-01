package com.app;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public List<Student> getAllStudents() {
        return List.of(
            new Student(1, "Raj", "IT"),
            new Student(2, "Amit", "CS"),
            new Student(3, "Neha", "ENTC")
        );
    }
}
