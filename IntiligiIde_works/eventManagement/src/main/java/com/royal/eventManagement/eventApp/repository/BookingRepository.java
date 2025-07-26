package com.royal.eventManagement.eventApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.royal.eventManagement.eventApp.entity.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    Optional<Booking> findByUserAndEvent(User user, Event event);
    boolean existsByUserAndEvent(User user, Event event);
}