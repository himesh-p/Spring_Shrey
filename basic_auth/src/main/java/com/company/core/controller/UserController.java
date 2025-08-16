package com.company.core.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.dto.UserRequestDTO;
import com.company.core.dto.UserResponseDTO;
import com.company.core.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	
	private final UserService service;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO requestDTO) {
		return ResponseEntity.ok(service.saveUser(requestDTO));
	}
	
	@GetMapping
	public 	ResponseEntity<List<UserResponseDTO>> getAll(){
		return ResponseEntity.ok(service.getAllUsers());
	}
}