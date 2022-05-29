package com.group2022103.flightkiosk.viewTest;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.model.*;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

public class AirlineViewTest {
	public AirlineView  testGetAirlineView() {
		List<Integer> airlineID = new LinkedList<Integer>(){{
		    add(1);
		    add(2);
		}};
		AirlineView airlineView = new AirlineView(new AirlineBack() {{
		 	setAirlineID(airlineID);
		}});
		return airlineView;
	}
	@Test
	public void getAirlineTest() {
		Application.run();
		Airline airline = testGetAirlineView().getAirline(1);
		assertEquals("AirOne",airline.getName());
	}
}
