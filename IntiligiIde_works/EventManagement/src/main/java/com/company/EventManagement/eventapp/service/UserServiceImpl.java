package com.company.EventManagement.eventapp.service;

import com.company.EventManagement.eventapp.entity.User;
import com.company.EventManagement.eventapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

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
        return repository.existByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
