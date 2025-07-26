package com.royal.eventManagement.eventApp.service;

import java.util.List;

import com.royal.eventManagement.eventApp.entity.*;

public interface BookingService {
    Booking bookEvent(User user, Event event);
    List<Booking> getBookingsByUser(User user);
}