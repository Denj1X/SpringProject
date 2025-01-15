package com.example.springstuff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 200, message = "Schedule name cannot be shorter than 2 or longer than 200")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "schedule")
    private Set<TrainJourney> trainJourneys;
}
