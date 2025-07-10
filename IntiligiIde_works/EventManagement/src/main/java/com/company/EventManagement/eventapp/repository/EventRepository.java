package com.company.EventManagement.eventapp.repository;

import com.company.EventManagement.eventapp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event , Long> {
    List<Event> findByEventDateAfter(LocalDateTime now);
    List<Event> findByTitleContainingIgnoreCase(String title);
}
