package com.royal.eventManagement.eventApp.service;

import java.util.List;
import java.util.Optional;

import com.royal.eventManagement.eventApp.entity.User;
import org.springframework.stereotype.Service;

import com.royal.eventManagement.eventApp.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByusername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}