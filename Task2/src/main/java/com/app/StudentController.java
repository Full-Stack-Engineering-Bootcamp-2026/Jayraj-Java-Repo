package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Value("${app.batch.name}")
    private String batchName;

   
    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam(required = false) String batch) {
        if (batch != null) {
            return studentService.getStudentsByBatch(batch);
        }
        return studentService.getAllStudents();
    }

 
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    
    @GetMapping("/batch")
    public String getBatch() {
        return "Current Batch: " + batchName;
    }
}
