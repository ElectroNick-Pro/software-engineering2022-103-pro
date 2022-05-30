package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.*;
import com.group2022103.flightkiosk.vo.FlightBack;

public class FlightControllerTest {
	@Test
	public void testGetFlightView() {
		Application.run();
    	List<String> flightID = new LinkedList<String>(){{
		    add("1");
		    add("2");
		    add("3");
		}};
		var para = new FlightBack();
		para.setFlightID(flightID);
		var ret = new FlightController().get(para).getFlights();
		assertTrue(ret.size() > 0);
		assertEquals(3,ret.size());
    }
}
