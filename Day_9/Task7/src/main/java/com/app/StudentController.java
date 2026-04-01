package com.app;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	//Accept: application/json
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getJsonStudents() {
	    return service.getAllStudents();
	}
	
	//Accept: application/xml
	@GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Student> getXmlStudents() {
	    return service.getAllStudents();
	}
	
	//Content-Type: application/json
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addStudent(@RequestBody Student student) {
	    return "Student added: " + student.getName();
	}
	
	//Accept: text/plain
	@GetMapping(value = "/text", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getText() {
	    return "Simple plain text response";
	}
	
	@GetMapping(value = "/html", produces = MediaType.TEXT_HTML_VALUE)
	public String getHtml() {
	    return "<h1>Student Page</h1><p>This is HTML response</p>";
	}
	
	
}
