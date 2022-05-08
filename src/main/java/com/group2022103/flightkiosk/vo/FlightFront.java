package com.group2022103.flightkiosk.vo;

import java.util.Map;

import com.group2022103.flightkiosk.model.Flight;

public class FlightFront {
	private Map<Integer, Flight> flights;

	public Map<Integer, Flight> getFlights() {
		return flights;
	}

	public void setFlights(Map<Integer, Flight> flights) {
		this.flights = flights;
	}
}
