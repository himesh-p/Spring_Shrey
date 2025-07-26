package com.royal.eventManagement.eventApp.repository;

import com.royal.eventManagement.eventApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByusername(String username);
    boolean existsByEmail(String email);
}