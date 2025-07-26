package com.royal.eventManagement.eventApp.service;

import java.util.List;
import java.util.Optional;

import com.royal.eventManagement.eventApp.entity.User;

public interface UserService {
    Optional<User> findByUsername(String username);
    User save(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> getAllUsers();
}