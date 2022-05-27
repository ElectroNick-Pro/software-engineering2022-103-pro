package com.group2022103.flightkiosk.viewTest;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.vo.*;
import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.view.AirlineView;
import com.group2022103.flightkiosk.view.FlightInfoView;
import com.group2022103.flightkiosk.view.FlightView;
import com.group2022103.flightkiosk.view.IntervalView;
import com.group2022103.flightkiosk.view.PlaneView;
import com.group2022103.flightkiosk.view.TicketView;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TicketViewTest {
	public TicketView testGetickets() {
		Application.run();
		TicketView ticketView = new TicketView(new TicketBack() {{
			setSurname("");
			setDocumentID("123456789012345678");
		}});
		assertEquals(3,ticketView.getTicketFront().getTickets().size());
		return ticketView;
	}
	@Test
	public void testGetTicket(){
		TicketView ticketView = testGetickets();
		Ticket ticket = ticketView.getTicket(0);
		assertEquals(3,(int)ticket.getId());
   	 	assertEquals("BK1101",ticket.getBookingId());
   	 	assertEquals(3,(int)ticket.getFlight());
		ticketView.getTicket(1);
	}
	@Test
	public void testGetTicketNum(){
		Application.run();
		TicketView ticketView = testGetickets();
		assertEquals(ticketView.getTicketFront().getTickets().size(),ticketView.getTicketNumber());
	}
	@Test
	public void testGetTicketID() {
		Application.run();
		List<String> ticketID = new LinkedList<String>(){{
		    add("3");
		    add("2");
		    add("1");
		}};
		assertEquals(ticketID,testGetickets().getTicketId());
	}

}	