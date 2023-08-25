package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bookings")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude={"userId,flightSrNo"})

public class Bookings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pnr_no;
	
	@Column
	private String passName;
	
	@Column
	private Long passContact;
	
	@Column
	private int passAge;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	@Column
	private double fare;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TicketType type;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User userId;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name="flight_srno")
	private Flights flightSrNo;
	

}
