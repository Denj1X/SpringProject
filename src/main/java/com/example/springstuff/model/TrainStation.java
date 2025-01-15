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
@Table(name = "train_station")
@AllArgsConstructor
@NoArgsConstructor
public class TrainStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 200, message = "Station name cannot be shorter than 2 or longer than 200")
    @Column(name = "station_name")
    private String stationName;

    @OneToMany(mappedBy = "startingStation")
    private List<Booking> startingBookings;

    @OneToMany(mappedBy = "endingStation")
    private List<Booking> endingBookings;
}
