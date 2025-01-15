package com.example.springstuff.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "journey_station")
@AllArgsConstructor
@NoArgsConstructor
public class JourneyStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false)
    private TrainJourney trainJourney;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private TrainStation trainStation;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "departure_time", nullable = false)
    private Date departureTime;

    @Column(name = "stop_order")
    private Integer stopOrder;
}
