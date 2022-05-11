package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group2022103.flightkiosk.controller.FlightController;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.vo.FlightBack;
import com.group2022103.flightkiosk.vo.FlightFront;
import com.group2022103.flightkiosk.vo.PlaneFront;

public class FlightView {
	private FlightFront flightFront;
	public FlightView(FlightBack flightBack) {
		/*Bypass backend begins*/
//		var map = new HashMap<Integer,Flight>();
		flightFront = new FlightFront();
//		this.flightFront.setFlights(map);
		/*Bypass backend ends*/
		 setFlightFront(new FlightController().get(flightBack));
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
		int number = this.getFlightFront().getFlights().size();
		List<String> flightID = new ArrayList<>();
		for (Map.Entry<Integer, Flight> entry : this.getFlightFront().getFlights().entrySet()) {
			 flightID.add(entry.getValue().getId().toString());
		}
		return flightID;
	}
	public List<String> getPlaneID(){
		int number = this.getFlightFront().getFlights().size();
		List<String> planeID = new ArrayList<>();
		for (Map.Entry<Integer, Flight> entry : this.getFlightFront().getFlights().entrySet()) {
			 planeID.add(entry.getValue().getPlane().toString());
		}
		return planeID;
	}
}
