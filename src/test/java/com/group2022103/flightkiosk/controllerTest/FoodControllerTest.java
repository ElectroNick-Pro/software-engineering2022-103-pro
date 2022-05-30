package com.group2022103.flightkiosk.controllerTest;
import static org.junit.Assert.assertEquals;


import org.junit.Test;
import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.FoodController;
import com.group2022103.flightkiosk.vo.FoodBack;
public class FoodControllerTest {
    private FoodBack req = new FoodBack();
	
	@Test
	public void test() {
		Application.run();
		req.setFlightId(3);
		assertEquals(36,(int) new FoodController().get(req).getOriginFood().get(1).getId());
	}
}
