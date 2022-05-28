package com.group2022103.flightkiosk.viewTest;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.model.*;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PlaneViewTest {
	public PlaneView getPlaneViewTest() {
		List<String> planeID = new LinkedList<String>(){{
		    add("1");
		    add("2");
		    add("3");
		}};
		PlaneView planeView = new PlaneView(new PlaneBack() {{
		 	setPlaneID(planeID);
		}});
		return planeView;
	}
	@Test
	public void getPlaneTest() {
		Application.run();
		Plane plane = getPlaneViewTest().getPlane(1);
		assertEquals("PlaneTypeOne",plane.getType());
	}
	@Test
	public void getAirlineIdTest() {
		Application.run();
		List<Integer> airlineId = new LinkedList<Integer>(){{
		    add(1);
		    add(1);
		    add(1);
		}};
		assertEquals(airlineId,getPlaneViewTest().getAirlineId());
	}
}
