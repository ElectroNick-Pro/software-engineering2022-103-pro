package com.group2022103.flightkiosk.view;

import java.util.Map;

import com.group2022103.flightkiosk.controller.AirlineController;
import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.vo.AirlineBack;
import com.group2022103.flightkiosk.vo.AirlineFront;

public class AirlineView {
	private AirlineFront airlineFront;
	public AirlineView(AirlineBack airlineBack){
		setAirlineFront(new AirlineController().get(airlineBack));
	}
	
	public AirlineFront getAirlineFront() {
		return airlineFront;
	}


	public void setAirlineFront(AirlineFront airlineFront) {
		this.airlineFront = airlineFront;
	}
	
	public Airline getAirline(int airlineID) {
		Map<Integer,Airline> airlines = this.getAirlineFront().getAirlines();
		Airline airline = airlines.get(airlineID);
		return airline;
	}
}
