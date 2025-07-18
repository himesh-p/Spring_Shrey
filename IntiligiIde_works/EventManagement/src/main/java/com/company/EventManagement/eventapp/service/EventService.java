package com.company.EventManagement.eventapp.service;

import com.company.EventManagement.eventapp.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    Event createEvent(Event event);
    List<Event> getUpcomingEvents();
    Optional<Event> getEventById(Long id);
    void updateSeats(Event event, int seatsToReduce);
}