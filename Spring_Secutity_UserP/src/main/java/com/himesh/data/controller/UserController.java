package com.himesh.data.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.himesh.data.dto.UserRequestDTO;
import com.himesh.data.dto.UserResponceDTO;
import com.himesh.data.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponceDTO> createUser(@Valid @RequestPart("user") UserRequestDTO user , 
			@RequestPart(value = "image" , required = false) MultipartFile image) throws IOException{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user, image));
	}
	
	@GetMapping()
	public List<UserResponceDTO> getAllUsers(){
		return service.getAllUsers();
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponceDTO> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getUserById(id)); 
	}
	
	@PutMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponceDTO> updateUser(@PathVariable Long id , @Valid @RequestPart("user") UserRequestDTO user , 
			@RequestPart(value = "image" , required = false) MultipartFile image) throws IOException{
		return ResponseEntity.ok(service.updateUser(id, user, image));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
