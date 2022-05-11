package com.group2022103.flightkiosk.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.SeatController;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;
import com.group2022103.flightkiosk.vo.TicketBack;

public class SeatViewTest {
	@Test
	public void test() {
		Application.run();
		SeatBack seatBack = new SeatBack();
		SeatFront seatFront = new SeatController().get(seatBack);
		SeatView seatView = new SeatView(seatBack);
		seatBack.setIntervalId(1);
		assertEquals(seatView.getSeat(1, "seat").get(0),seatView.getSeat(1, "interval").get(0));
		
	}
}
