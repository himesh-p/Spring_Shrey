package com.company.EventManagement.eventapp.service;

import com.company.EventManagement.eventapp.entity.Booking;
import com.company.EventManagement.eventapp.entity.Event;
import com.company.EventManagement.eventapp.entity.User;

import java.util.List;

public interface BookingService {
    Booking bookEvent(User user, Event event);
    List<Booking> getBookingsByUser(User user);
}