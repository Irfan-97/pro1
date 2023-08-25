package com.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Flights;

public interface FlightsRepository extends JpaRepository<Flights, Long> {
	
	@Query("select f from Flights f where f.source=?1 and f.destination=?2 and f.journeyDate=?3")
	List<Flights> getallflights(String source, String destination, LocalDate journeyDate);
	
	Flights findByFlightSrNo(String flightSrNo);
	Flights findByFlightSrNo(Flights flightSrNo);
	
	
}