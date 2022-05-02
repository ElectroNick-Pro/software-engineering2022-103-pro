package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.vo.TicketBack;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicketViewTest {
	@Test
	public void test() {
		TicketView ticketView = new TicketView(new TicketBack() {{
			setSurname("");
			setDocumentID("");
		}});
		assertEquals(1,ticketView.getTicketFront().getTickets().size());
		var tickets = ticketView.getTicketFront().getTickets().toArray();
		assertEquals("123123123",((Ticket)tickets[0]).getBookingId());
		
	}
}
