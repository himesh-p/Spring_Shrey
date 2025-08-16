package com.company.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.config.JwtUtil;
import com.company.core.dto.AuthRequest;
import com.company.core.dto.AuthResponse;
import com.company.core.entity.UserEntity;
import com.company.core.repository.UserRepository;
import com.company.core.service.CustomerDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final PasswordEncoder encoder;
	private final UserRepository repository;
	private final JwtUtil util;
	private final CustomerDetailsService userDetailsService;
	private final AuthenticationManager authManager;
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		UserDetails user = userDetailsService.loadUserByUsername(authRequest.getUsername());
		String token = util.generateToken(user);
		
		return new AuthResponse(token);
	}
	 
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody UserEntity entity){
		if(repository.findByUsername(entity.getUsername()).isPresent()) {
			return ResponseEntity.badRequest().body("Username already exist!!!");
		}
		UserEntity entity2 = new UserEntity();
		entity2.setUsername(entity.getUsername());
		entity2.setPassword(encoder.encode(entity.getPassword()));
		entity2.setRole(entity.getRole());
		repository.save(entity2);
		return ResponseEntity.ok("User registered successfully!!!");
	}
}
