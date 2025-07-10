package com.company.EventManagement.eventapp.repository;

import com.company.EventManagement.eventapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);
    boolean existByUsername(String username);
    boolean existByEmail(String email);
}
