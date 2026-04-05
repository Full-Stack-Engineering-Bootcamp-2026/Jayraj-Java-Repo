package com.app.dto;

import com.app.validation.MindbowserEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {
	
	
	@NotBlank(message = "Name cannot be empty")
	@Size(min = 3, max = 50)
    private String name;

    @Email(message = "Invalid email format")
    @MindbowserEmail
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private double salary;

    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 60, message = "Maximum age is 60")
    private int age;

    @NotBlank(message = "Role is required")
    @Size(min = 3, max = 50)
    private String role;

    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;

    @NotNull(message = "Department is required")
    private Integer departmentId;
    
}
