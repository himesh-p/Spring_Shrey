package com.company.EventManagement.eventapp.service;

import com.company.EventManagement.eventapp.entity.Booking;
import com.company.EventManagement.eventapp.entity.Event;
import com.company.EventManagement.eventapp.entity.User;
import com.company.EventManagement.eventapp.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService{

    private final BookingRepository repository;
    private final EventService service;

    @Override
    public Booking bookEvent(User user, Event event) {
        if (repository.existByUserAndEvent(user,event)){
            throw new IllegalArgumentException("User already booked this event.");
        }
        service.updateSeats(event,1);
        Booking booking = Booking.builder()
                .user(user)
                .event(event)
                .bookingDate(LocalDateTime.now())
                .build();

        return repository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(User user) {
        return repository.findByUser(user
        );
    }
}
