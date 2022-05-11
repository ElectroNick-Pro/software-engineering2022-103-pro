package com.group2022103.flightkiosk.view;

import java.util.HashMap;
import java.util.Map;

import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.vo.AirlineBack;
import com.group2022103.flightkiosk.vo.AirlineFront;
import com.group2022103.flightkiosk.vo.FlightFront;

public class AirlineView {
	private AirlineFront airlineFront;
	public AirlineView(AirlineFront airlineFront){
		var map = new HashMap<Integer,Airline>();
		airlineFront = new AirlineFront();
		this.airlineFront.setAirlines(map);
		/*Bypass backend ends*/
//		setFlightFront(new AirlineController().get(airlineBack));
	}
	
	public AirlineFront getAirlineFront() {
		return airlineFront;
	}


	public void setAirlineFront(AirlineFront airlineFront) {
		this.airlineFront = airlineFront;
	}
	
	public Airline getAirline(String airlineID) {
		Map<Integer,Airline> airlines = this.getAirlineFront().getAirlines();
		Airline airline = airlines.get(airlineID);
		return airline;
	}
}
