package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private Long mobNo;
	
	@Column
	private String securityQues;
	
	@Column
	private String ans;
	
	@Column
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	
	
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Bookings> ticketList=new ArrayList<>();
	
	public void addTicket(Bookings ticket) {
		ticketList.add(ticket);
		//ticket.setUserId(this);
	}
	
	public void removeTicket(Bookings ticket) {
		ticketList.remove(ticket);
		//ticket.setUserId(null);
	}
	
	
	
	

}
