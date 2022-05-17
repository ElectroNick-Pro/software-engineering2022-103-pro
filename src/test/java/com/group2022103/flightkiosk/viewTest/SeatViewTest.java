package com.group2022103.flightkiosk.viewTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.nio.channels.NonWritableChannelException;
import java.util.List;

import javax.swing.plaf.ColorUIResource;

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
		SeatBack seatBack = new SeatBack(){{
			setTicketId(-1);
			setSeatId(1);
			setIntervalId(-1);
		}};
		SeatView seatView = new SeatView(seatBack);
		SeatFront seatFront = new SeatController().get(seatBack);
		List<Seat> seats = seatView.getSeatFront();
		assertEquals(seats.get(0).getSeatNo(), "1A");
		assertEquals(seatView.getRowLength(), 10);
		assertEquals(seatView.getColumnLength(), 4);
		
		ColorUIResource[] color = new ColorUIResource[2];
		color[0] = new ColorUIResource(249,237,166);
		color[1] = new ColorUIResource(205,205,205);
		assertEquals(seatView.getButtonColor(), color);
		
		assertEquals(seatView.canChooseSeat(), true);
		assertEquals(seatView.getSeatStatus(), 0);
		assertEquals(seatView.getAllSeats(), seatView.getSeatFront());
		
	}
}
