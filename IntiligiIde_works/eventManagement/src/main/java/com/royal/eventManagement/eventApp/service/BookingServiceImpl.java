package com.royal.eventManagement.eventApp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.royal.eventManagement.eventApp.entity.Booking;
import com.royal.eventManagement.eventApp.entity.Event;
import com.royal.eventManagement.eventApp.entity.User;
import org.springframework.stereotype.Service;

import com.royal.eventManagement.eventApp.repository.BookingRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final EventService service;

    @Override
    public Booking bookEvent(User user, Event event) {
        if (repository.existsByUserAndEvent(user, event)) {
            throw new IllegalArgumentException("User already booked this event.");
        }

        service.updateSeats(event, 1);	//Decrease available seats
        Booking booking = Booking.builder()
                .user(user)
                .event(event)
                .bookingTime(LocalDateTime.now())
                .build();

        return repository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        return repository.findByUser(user);
    }
}