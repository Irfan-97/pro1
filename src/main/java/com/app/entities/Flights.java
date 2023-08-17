package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long flightNo;
	
	@Column
	private String source;
	
	@Column
	private String Destination;
	
	@Column
	private LocalTime deptTime;
	
	@Column
	private LocalTime arrTime;
	
	@Column
	private LocalDate journeyDate;
	
	
	

}
