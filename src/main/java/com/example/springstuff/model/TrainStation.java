package com.example.springstuff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private long id;

    @Size(min = 2, max = 200, message = "Station name cannot be shorter than 2 or longer than 200")
    @Column(name = "station_name")
    private String stationName;
}
