package com.app.entity;
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

    @NotBlank(message = "Department is required")
    private String department;

    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 1000)
    private double salary;

    @Min(18)
    @Max(60)
    private int age;

    private String role;

    @Pattern(regexp = "\\d{10}")
    private String phone;
}