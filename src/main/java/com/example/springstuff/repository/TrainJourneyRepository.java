package com.example.springstuff.repository;

import com.example.springstuff.model.TrainJourney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainJourneyRepository extends JpaRepository<TrainJourney, Long> {
}