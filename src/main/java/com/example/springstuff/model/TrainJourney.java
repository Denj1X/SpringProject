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
@Table(name = "train_journey")
@AllArgsConstructor
@NoArgsConstructor

public class TrainJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @Size(min = 2, max = 500, message = "First name cannot be shorter than 2 or longer than 500")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "trainJourney")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "trainJourney")
    private List<JourneyStation> journeyStations;

    @OneToMany(mappedBy = "trainJourney")
    private List<JourneyCarriage> journeyCarriages;
}
