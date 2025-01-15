package com.example.springstuff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "booking_status")
public class BookingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 30, message = "Booking status name cannot be shorter than 2 or longer than 30")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "status")
    private List<Booking> bookings;

    public BookingStatus() {
    }

    public BookingStatus(String name) {
        this.name = name;
    }

    public BookingStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
