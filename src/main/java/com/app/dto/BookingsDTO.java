package com.app.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entities.Flights;
import com.app.entities.Gender;
import com.app.entities.TicketType;
import com.app.entities.User;
import com.app.entities.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BookingsDTO {

	
	@JsonProperty(access=Access.READ_ONLY)
	private Long pnr_no;
	
	private String passName;
	
	private Long passContact;
	
	private int passAge;
	
	private Gender gender;
	
	private Double fare;
	
	private TicketType type;
	
	
	private Long userId;
	
	private String flightSrNo;
}
