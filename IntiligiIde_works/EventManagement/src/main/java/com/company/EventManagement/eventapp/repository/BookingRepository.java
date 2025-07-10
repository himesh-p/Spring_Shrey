package com.company.EventManagement.eventapp.repository;

import com.company.EventManagement.eventapp.entity.Booking;
import com.company.EventManagement.eventapp.entity.Event;
import com.company.EventManagement.eventapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking , Long> {
    List<Booking> findByUser(User user);
    Optional<Booking> findByUserAndEvent(User user, Event event);
    boolean existByUserAndEvent(User user, Event event);
}