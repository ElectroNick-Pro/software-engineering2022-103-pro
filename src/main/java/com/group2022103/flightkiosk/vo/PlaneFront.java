package com.group2022103.flightkiosk.vo;

import java.util.Map;

import com.group2022103.flightkiosk.model.Plane;

public class PlaneFront {
	// planeId-plane
	private Map<Integer,Plane> planes;

	public Map<Integer,Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(Map<Integer,Plane> planes) {
		this.planes = planes;
	}
}
