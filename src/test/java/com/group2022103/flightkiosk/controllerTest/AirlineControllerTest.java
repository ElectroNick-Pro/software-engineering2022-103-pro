package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.*;
import com.group2022103.flightkiosk.vo.*;

public class AirlineControllerTest {
	@Test
	public void test() {
		Application.run();
		List<Integer> airlineID = new LinkedList<Integer>(){{
		    add(1);
		    add(2);
		}};
		var para = new AirlineBack();
		para.setAirlineID(airlineID);
		var ret = new AirlineController().get(para).getAirlines();
		assertTrue(ret.size() > 0);
		assertEquals(2,ret.size());
	}
}
