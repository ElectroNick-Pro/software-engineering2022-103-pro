package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.ConfirmPayController;
import com.group2022103.flightkiosk.mapper.SeatMapper;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.vo.ConfirmPayBack;

public class ConfirmPayControllerTest {
	
	private ConfirmPayBack req = new ConfirmPayBack();
	private SeatMapper seatMapper;
	
	@Test
	public void test() {
		Application.run();
		seatMapper = (SeatMapper) Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
		req.setFoodChoice(new ArrayList<FoodPurchase>() {{
			add(new FoodPurchase() {{
				setFood(1);
				setCount(1);
				setTicket(1);
			}});
			add(new FoodPurchase() {{
				setFood(2);
				setCount(3);
				setTicket(1);
			}});
			add(new FoodPurchase() {{
				setFood(3);
				setCount(10);
				setTicket(1);
			}});
		}});
		var seat = seatMapper.getById(1);
		seat.setTicket(1);
		req.setSeat(seat);
		new ConfirmPayController().get(req);
		assertEquals(1, seatMapper.getById(1).getTicket().intValue());
	}

}
