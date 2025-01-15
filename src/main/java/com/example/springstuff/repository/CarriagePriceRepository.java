package com.example.springstuff.repository;

import com.example.springstuff.model.CarriagePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriagePriceRepository extends JpaRepository<CarriagePrice, Long> {
}