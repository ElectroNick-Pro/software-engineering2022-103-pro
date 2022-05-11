package com.group2022103.flightkiosk.vo;

import java.util.Map;

import com.group2022103.flightkiosk.model.Airline;

public class AirlineFront {
	private Map<Integer, Airline> airlines;

	public Map<Integer, Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(Map<Integer, Airline> airlines) {
		this.airlines = airlines;
	}
}
