package com.example.springstuff.repository;

import com.example.springstuff.model.Passenger;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {
    Optional<Passenger> findByUsername(String username);
    boolean existsByUsername(String username);
}
