package com.app;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "Raj", "CDAC-2026", "raj@gmail.com"));
        list.add(new Student(2, "Amit", "CDAC-2025", "amit@gmail.com"));
        list.add(new Student(3, "Neha", "CDAC-2026", "neha@gmail.com"));

        return list;
    }

    public Student getStudentById(int id) {
        return getAllStudents()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

   
    public List<Student> getStudentsByBatch(String batch) {
        return getAllStudents()
                .stream()
                .filter(s -> s.getBatch().equalsIgnoreCase(batch))
                .toList();
    }
}
