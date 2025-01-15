package com.example.springstuff.service;

import com.example.springstuff.exceptions.ResourceNotFoundException;
import com.example.springstuff.model.Booking;
import com.example.springstuff.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking createBooking(Booking booking) {
        if (booking.getId() != null) {
            throw new IllegalArgumentException("New bookings should not have an ID");
        }
        booking.setBookingDate(new Date());
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Optional<Booking> optionalBooking = getBookingById(id);

        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();
            existingBooking.setAmountPaid(updatedBooking.getAmountPaid());
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            existingBooking.setSeatNo(updatedBooking.getSeatNo());
            return bookingRepository.save(existingBooking);
        } else {
            throw new ResourceNotFoundException("Booking not found with id: " + id);
        }
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id: " + id);
        }
        bookingRepository.deleteById(id);
    }
}