package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);
	
	@Query("select u from User u left join fetch u.ticketList where u.userId=?1")
	User getUserAndBookingDetails(Long userId);

}
