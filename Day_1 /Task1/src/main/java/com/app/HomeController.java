package com.app;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/hello")
    public String sayHello() {
        return "Hello, I am Jayraj!";
    }

   
    @GetMapping("/about")
    public String about() {
        return "I am Jayraj, CDAC student, passionate about software development.";
    }

   
    @GetMapping("/status")
    public String status() {
        return "Spring Boot is running!";
    }

    
    @GetMapping("/time")
    public String getTime() {
        return LocalDateTime.now().toString();
    }

}
