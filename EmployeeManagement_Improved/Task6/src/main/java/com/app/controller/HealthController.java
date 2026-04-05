package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.response.ApiResponse;

@RestController
@RequestMapping("/health")
public class HealthController {
	
	@GetMapping
	public ResponseEntity<ApiResponse<String>> health() {

	    ApiResponse<String> response =
	        new ApiResponse<>(true, "Application is running", "OK");

	    return ResponseEntity.ok(response);
	}
}
