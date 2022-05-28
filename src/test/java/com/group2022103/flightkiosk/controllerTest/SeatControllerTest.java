package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.SeatController;
import com.group2022103.flightkiosk.mapper.SeatMapper;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.vo.SeatBack;

public class SeatControllerTest {
	private SeatMapper seatMapper;
	private SeatBack req = new SeatBack();
	private List<Seat> seats;
	
	@Test
	public void test() {
		Application.run();
		seatMapper = (SeatMapper) Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
		
		req.setIntervalId(1);
		req.setSeatId(-1);
		req.setTicketId(-1);
		seats = new SeatController().get(req).getSeats();
		assertEquals(40, seats.size());
		
		req.setIntervalId(-1);
		req.setSeatId(1);
		req.setTicketId(-1);
		seats = new SeatController().get(req).getSeats();
		assertEquals("1A", seats.get(0).getSeatNo());
		
		//当seat的ticket为空时，就会报错
		req.setIntervalId(-1);
		req.setSeatId(-1);
		req.setTicketId(1);
		seats = new SeatController().get(req).getSeats();
		assertEquals("1A", seats.get(0).getSeatNo());
	}
}
