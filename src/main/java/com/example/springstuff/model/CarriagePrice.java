package com.example.springstuff.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carriage_price")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarriagePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "carriage_class_id", nullable = false)
    private CarriageClass carriageClass;

    private Double price;
}
