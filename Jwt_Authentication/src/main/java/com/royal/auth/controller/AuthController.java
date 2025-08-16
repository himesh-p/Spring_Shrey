package com.royal.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royal.auth.dto.UserDTO;
import com.royal.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

		private final UserService service;
		
		@PostMapping
		public String authenticateUser(@RequestBody UserDTO userDTO) {
			return service.authenticate(userDTO);
		}
		
		@GetMapping("/hello")
		public String hello() {
			return "Hello, Authenticated User!!!";
		}
}