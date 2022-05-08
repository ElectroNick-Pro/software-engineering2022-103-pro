package com.group2022103.flightkiosk.view;

import java.util.HashMap;
import java.util.Map;

import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.vo.FlightFront;
import com.group2022103.flightkiosk.vo.PlaneFront;

public class FlightView {
	private FlightFront flightFront;
	public FlightView(FlightFront flightFront) {
		/*Bypass backend begins*/
		var map = new HashMap<Integer,Flight>();
		flightFront = new FlightFront();
		this.flightFront.setFlights(map);
		/*Bypass backend ends*/
		// setFlightFront(new FlightController().getFlight(flightBack));
	}
	public FlightFront getFlightFront() {
		return flightFront;
	}
	public void setFlightFront(FlightFront flightFront) {
		this.flightFront = flightFront;
	}
	public Flight getFlight(int flightID){
		Map<Integer,Flight> map = this.getFlightFront().getFlights();
		Flight flight = map.get(flightID);
		return flight;
	}
	
}
