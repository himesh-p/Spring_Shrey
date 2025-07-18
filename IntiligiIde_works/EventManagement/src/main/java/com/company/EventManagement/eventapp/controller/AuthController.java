package com.company.EventManagement.eventapp.controller;

import com.company.EventManagement.eventapp.entity.Role;
import com.company.EventManagement.eventapp.entity.User;
import com.company.EventManagement.eventapp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user){
        if(service.existsByUsername(user.getUsername())){
            ResponseEntity.badRequest().body("Username is already taken");
        }
        if(service.existsByEmail(user.getEmail())){
            ResponseEntity.badRequest().body("Email is already taken");
        }
        if(user.getRole() == null) user.setRole(Role.USER);
        service.save(user);
        return ResponseEntity.ok("User registered successfully!!!");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }
}