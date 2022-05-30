package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.group2022103.flightkiosk.controller.FlightController;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.vo.FlightBack;
import com.group2022103.flightkiosk.vo.FlightFront;

public class FlightView {
	
	private FlightFront flightFront;

	public FlightView(FlightBack flightBack) {
		flightFront = new FlightController().get(flightBack);
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
	
	public List<String> getFlightID(){
		List<String> flightID = new ArrayList<>();
		for (Map.Entry<Integer, Flight> entry : this.getFlightFront().getFlights().entrySet()) {
			 flightID.add(entry.getValue().getId().toString());
		}
		return flightID;
	}
	
	public List<String> getPlaneID(){
		List<String> planeID = new ArrayList<>();
		for (Map.Entry<Integer, Flight> entry : this.getFlightFront().getFlights().entrySet()) {
			 planeID.add(entry.getValue().getPlane().toString());
		}
		return planeID;
	}

	public Map<Integer, Flight> getFlights() {
		return flightFront.getFlights();
	}
}
