package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name="flights")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Flights {
	
	@Id
	private String flightSrNo;
	
	@Column
	private String flightNo;
	
	@Column
	private String source;
	
	@Column
	private String destination;
	
	@Column
	private LocalTime deptTime;
	
	@Column
	private LocalTime arrTime;
	
	@Column
	private LocalDate journeyDate;
	
	
	@OneToMany(mappedBy = "flightSrNo", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Bookings> fTicketList=new ArrayList<>();
	
	public void addTicket(Bookings ticket) {
		fTicketList.add(ticket);
		//ticket.setFlightSrNo(this);
	}
	
	public void removeTicket(Bookings ticket) {
		fTicketList.remove(ticket);
		//ticket.setFlightSrNo(null);
	}
	
	

}
