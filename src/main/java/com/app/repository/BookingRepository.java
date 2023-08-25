package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Bookings;
import com.app.entities.Flights;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
	
	//List<Bookings> findByUserId(Long userId);
//@Query(value="select * from bookings  where user_id=?1",nativeQuery = true)
	
	
//	@Query("select b from Bookings b where b.userId=?1")
//	List<Bookings> myBookings(Long userId);
	
//	@Query("SELECT b FROM Bookings b WHERE b.userId = :userId")
//	List<Bookings> myBookings(@Param("userId") Long userId);
	
}
