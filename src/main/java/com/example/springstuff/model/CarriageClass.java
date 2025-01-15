package com.example.springstuff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "carriage_class")
@AllArgsConstructor
@NoArgsConstructor
public class CarriageClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 50, message = "Carriage class name cannot be shorter than 2 or longer than 50")
    @Column(name = "class_name")
    private String className;

    @Column(name = "seating_capacity")
    private int seatingCapacity;

    @OneToMany(mappedBy = "ticketClass")
    private List<Booking> bookings;
}
