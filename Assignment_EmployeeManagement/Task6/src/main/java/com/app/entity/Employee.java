package com.app.entity;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String name;
    
    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 1000)
    private Double salary;

    @Min(18)
    @Max(60)
    private Integer age;

    private String role;
 
    @Pattern(regexp = "\\d{10}")
    private String phone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id") 
    private Department department;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id") 
    private Address address;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_project", 
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;
}