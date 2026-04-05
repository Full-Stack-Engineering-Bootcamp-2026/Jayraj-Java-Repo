package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeRequestDTO;
import com.app.dto.EmployeeResponseDTO;
import com.app.response.ApiResponse;
import com.app.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getById(@PathVariable Integer id) {

	    EmployeeResponseDTO data = service.getById(id);

	    ApiResponse<EmployeeResponseDTO> response =
	        new ApiResponse<>(true, "Employee fetched successfully", data);

	    return ResponseEntity.ok(response);
	}
    
    
	@GetMapping
	public ResponseEntity<ApiResponse<List<EmployeeResponseDTO>>> getAll() {

	    List<EmployeeResponseDTO> data = service.getAll();

	    ApiResponse<List<EmployeeResponseDTO>> response =
	        new ApiResponse<>(true, "Employees fetched successfully", data);

	    return ResponseEntity.ok(response);
	}
    
    
    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> create(
            @Valid @RequestBody EmployeeRequestDTO dto) {

        EmployeeResponseDTO data = service.save(dto);

        ApiResponse<EmployeeResponseDTO> response =
            new ApiResponse<>(true, "Employee created successfully", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> update(
            @PathVariable Integer id,
            @Valid @RequestBody EmployeeRequestDTO dto) {

        EmployeeResponseDTO data = service.update(id, dto);

        ApiResponse<EmployeeResponseDTO> response =
            new ApiResponse<>(true, "Employee updated successfully", data);

        return ResponseEntity.ok(response);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Integer id) {

        service.delete(id);

        ApiResponse<Object> response =
            new ApiResponse<>(true, "Employee deleted successfully", null);

        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/{empId}/projects/{projectId}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> assignProject(
            @PathVariable Integer empId,
            @PathVariable Integer projectId) {

        EmployeeResponseDTO data = service.assignProject(empId, projectId);

        ApiResponse<EmployeeResponseDTO> response =
            new ApiResponse<>(true, "Project assigned successfully", data);

        return ResponseEntity.ok(response);
    }
    

}
