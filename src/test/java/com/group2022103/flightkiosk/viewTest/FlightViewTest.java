package com.group2022103.flightkiosk.viewTest;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.view.*;

import org.junit.Test;

import com.group2022103.flightkiosk.vo.*;

public class FlightViewTest {
    public FlightView testGetFlightView() {
    	List<String> flightID = new LinkedList<String>(){{
		    add("1");
		    add("2");
		    add("3");
		}};
    	FlightView flightView = new FlightView(new FlightBack() {{
    	 	setFlightID(flightID);
    	 }});
    	return flightView;
    }
    @Test
    public void getFlightTest() {
    	Application.run();
    	FlightView flightView = testGetFlightView();
    	Flight flight = flightView.getFlight(1);
    	assertEquals("133253",flight.getFlightNo());
    }
    @Test
    public void getPlaneIdTest() {
    	Application.run();
    	List<String> planeID = new LinkedList<String>(){{
		    add("1");
		    add("2");
		    add("3");
		}};
		assertEquals(planeID,testGetFlightView().getPlaneID());
    }
}
