package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.*;
import com.group2022103.flightkiosk.vo.*;

public class PlaneControllerTest {
	@Test
	public void test() {
		Application.run();
		List<String> planeID = new LinkedList<String>(){{
		    add("1");
		    add("2");
		    add("3");
		}};
		var para = new PlaneBack();
		para.setPlaneID(planeID);
		var ret = new PlaneController().get(para).getPlanes();
		assertTrue(ret.size() > 0);
		assertEquals(3,ret.size());
		assertEquals("PlaneTypeOne",ret.get(1).getType());
	}
}
