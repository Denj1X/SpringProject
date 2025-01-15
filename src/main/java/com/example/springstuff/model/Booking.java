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
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private BookingStatus status;

    @ManyToOne
    @JoinColumn(name = "starting_station_id", nullable = false)
    private TrainStation startingStation;

    @ManyToOne
    @JoinColumn(name = "ending_station_id", nullable = false)
    private TrainStation endingStation;

    @ManyToOne
    @JoinColumn(name = "train_journey_id", nullable = false)
    private TrainJourney trainJourney;

    @ManyToOne
    @JoinColumn(name = "ticket_class_id", nullable = false)
    private CarriageClass ticketClass;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @Column(name = "ticket_no", nullable = false, unique = true)
    private Long ticketNo;

    @Column(name = "seat_no", nullable = false)
    private Long seatNo;
}
