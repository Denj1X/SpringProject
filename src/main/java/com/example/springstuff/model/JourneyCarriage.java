package com.example.springstuff.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "journey_carriage")
@AllArgsConstructor
@NoArgsConstructor
public class JourneyCarriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false)
    private TrainJourney trainJourney;

    @ManyToOne
    @JoinColumn(name = "carriage_class_id", nullable = false)
    private CarriageClass carriageClass;

    private int position;
}
