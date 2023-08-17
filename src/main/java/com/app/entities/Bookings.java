package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bookings")
@NoArgsConstructor
@Getter
@Setter

public class Bookings {
	
	@Id
	private Long pnr_no;
	
	@Column
	private String passName;
	
	@Column
	private Long passContact;
	
	@Column
	private int passAge;
	
	@Column
	private Gender gender;
	
	@Column
	private String securityQues;
	
	@Column
	private Double fare;
	
	@Column
	private TicketType type;
	

}
