package com.group2022103.flightkiosk.viewTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.SeatController;
import com.group2022103.flightkiosk.mapper.*;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.view.SeatView;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;
import com.group2022103.flightkiosk.vo.TicketBack;

public class SeatViewTest {
	@Test
	public void test() {
		Application.run();
		SeatMapper seatMapper = (SeatMapper) Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
		assertNotEquals(null, seatMapper.queryAll());
	}
}
