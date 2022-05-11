package com.group2022103.flightkiosk.view;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group2022103.flightkiosk.controller.PlaneController;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.vo.PlaneBack;
import com.group2022103.flightkiosk.vo.PlaneFront;
import com.group2022103.flightkiosk.vo.TicketFront;

public class PlaneView {
	private PlaneFront planeFront;
	public PlaneView(PlaneBack planeBack) {
		/*Bypass backend begins*/
//		var map = new HashMap<Integer,Plane>();
		planeFront = new PlaneFront();
//		this.planeFront.setPlanes(map);
		/*Bypass backend ends*/
		 setPlaneFront(new PlaneController().get(planeBack));
	}
	public PlaneFront getPlaneFront() {
		return planeFront;
	}
	public void setPlaneFront(PlaneFront planeFront) {
		this.planeFront = planeFront;
	}
	public Plane getPlane(int flightID) {
		Map<Integer,Plane> planes = this.getPlaneFront().getPlanes();
		Plane plane = planes.get(flightID);
		return plane;
	}
	public List<Integer> getAirlineId(){
		int num = this.getPlaneFront().getPlanes().size();
		List<Integer> airlineID = new ArrayList<>();
		for (Map.Entry<Integer, Plane> entry : this.getPlaneFront().getPlanes().entrySet()) {
			 airlineID.add(entry.getValue().getAirline());
		}
		return airlineID;
	}
	
	
}
