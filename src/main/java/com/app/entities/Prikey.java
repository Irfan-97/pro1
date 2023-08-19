package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Prikey implements Serializable {

	
	private Long flightNo;
	private LocalDate journeyDate;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(flightNo, journeyDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prikey other = (Prikey) obj;
		return Objects.equals(flightNo, other.flightNo) && Objects.equals(journeyDate, other.journeyDate);
	}
	
	
}
