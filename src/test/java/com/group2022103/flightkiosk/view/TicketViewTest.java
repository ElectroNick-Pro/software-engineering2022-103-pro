package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.vo.*;
import com.group2022103.flightkiosk.model.Ticket;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TicketViewTest {
	@Test
	public void testGeticket() {
		Application.run();
		TicketView ticketView = new TicketView(new TicketBack() {{
			setSurname("");
			setDocumentID("123456789012345678");
		}});
		assertEquals(3,ticketView.getTicketNumber());
		Ticket ticket = ticketView.getTicket(0);
		assertEquals(1,(int)ticket.getId());
		assertEquals("BK1001",ticket.getBookingId());
		assertEquals(1,(int)ticket.getFlight());
		FlightView flightView = new FlightView(new FlightBack() {{
			setFlightID(ticketView.getTicketId());
		}});
		assertEquals(3,flightView.getFlightFront().getFlights().size());
		assertEquals(1,(int)flightView.getFlightFront().getFlights().get(1).getId());
		assertEquals("2",flightView.getFlightID().get(1));
		IntervalView intervalView = new IntervalView(new IntervalBack() {{
			setFlightID(flightView.getFlightID());
		}});
//		assertEquals(3,intervalView.getIntervalFront().getIntervals().size());
	}
}	