package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Flights;

public interface FlightsRepository extends JpaRepository<Flights, Long> {

}
