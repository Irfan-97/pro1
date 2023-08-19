package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Bookings;
import com.app.entities.Flights;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
	
	//List<Bookings> findByUserId(Long userId);

	@Query("select b from Bookings b where b.userId=?1")
	List<Bookings> myBookings(Long userId);
	
}
