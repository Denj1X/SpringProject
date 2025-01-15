package com.example.springstuff;

import com.example.springstuff.model.Booking;
import com.example.springstuff.model.Passenger;
import com.example.springstuff.repository.BookingRepository;
import com.example.springstuff.repository.PassengerRepository;
import com.example.springstuff.service.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Date;
import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerService passengerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPassengers() {
        List<Passenger> passengers = Arrays.asList(new Passenger(1L, "John", "Doe", "john@example.com", "password", null, "ROLE_USER"));
        when(passengerRepository.findAll()).thenReturn(passengers);

        List<Passenger> result = passengerService.getAllPassengers();
        assertEquals(1, result.size());
        verify(passengerRepository, times(1)).findAll();
    }

    @Test
    void testGetPassengerById() {
        Passenger passenger = new Passenger(1L, "John", "Doe", "john@example.com", "password", null, "ROLE_USER");
        when(passengerRepository.findById(1L)).thenReturn(Optional.of(passenger));

        Optional<Passenger> result = passengerService.getPassengerById(1L);
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getFirstName());
    }

    @Test
    void testCreatePassenger() {
        Passenger passenger = new Passenger(null, "John", "Doe", "john@example.com", "password", null, "ROLE_USER");
        when(passengerRepository.save(any(Passenger.class))).thenReturn(passenger);

        Passenger result = passengerService.createPassenger(passenger);
        assertNotNull(result);
        verify(passengerRepository, times(1)).save(passenger);
    }
}