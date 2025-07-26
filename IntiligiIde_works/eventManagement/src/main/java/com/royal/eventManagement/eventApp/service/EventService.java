package com.royal.eventManagement.eventApp.service;

import java.util.List;
import java.util.Optional;

import com.royal.eventManagement.eventApp.entity.Event;

public interface EventService {
    Event createEvent(Event event);
    List<Event> getUpcomingEvents();
    Optional<Event> getEventById(Long id);
    void updateSeats(Event event, int seatsToReduce);
}