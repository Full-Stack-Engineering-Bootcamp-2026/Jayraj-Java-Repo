package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private Integer id;
	private String name;
	private String department;
	private String email;
	private double salary;
}
