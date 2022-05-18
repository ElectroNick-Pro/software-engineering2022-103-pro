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

import java.util.List;

import org.junit.Test;

public class TicketViewTest {
	@Test
	public TicketView testGetickets() {
		Application.run();
		TicketView ticketView = new TicketView(new TicketBack() {{
			setSurname("");
			setDocumentID("123456789012345678");
		}});
		assertEquals(3,ticketView.getTicketFront().getTickets().size());
		return ticketView;
		// Ticket ticket = ticketView.getTicket(0);
		// assertEquals(1,(int)ticket.getId());
		// assertEquals("BK1001",ticket.getBookingId());
		// assertEquals(1,(int)ticket.getFlight());
		// FlightView flightView = new FlightView(new FlightBack() {{
		// 	setFlightID(ticketView.getTicketId());
		// }});
		// assertEquals(3,flightView.getFlightFront().getFlights().size());
		// assertEquals(1,(int)flightView.getFlightFront().getFlights().get(1).getId());
		// assertEquals("2",flightView.getFlightID().get(1));
		// PlaneView planeView = new PlaneView(new PlaneBack() {{
		// 	setPlaneID(flightView.getPlaneID());
		// }});
		// assertEquals(3,planeView.getPlaneFront().getPlanes().size());
		// IntervalView intervalView = new IntervalView(new IntervalBack() {{
		// 	setFlightID(flightView.getFlightID());
		// }});
		// assertEquals(3,intervalView.getIntervalFront().getIntervals().size());
	}
	public void testGetTicket(){
		TicketView ticketView = testGetickets();
		ticketView.getTicket(0);

		ticketView.getTicket(1);
	}
	public void testGetTicketNum(){
		Application.run();
		TicketView ticketView = testGetickets();
		assertEquals(ticketView.getTicketFront().getTickets().size(),ticketView.getTicketNumber());
	}
	// public void testGetAllInfo(TicketView tickets,FlightView flights,IntervalView intervals,
	// 		PlaneView planes,AirlineView airline) {
	// 	int num = tickets.getTicketNumber();
	// 	for(int i = 0; i < num;i++) {
	// 		Ticket ticket = tickets.getTicket(i);
	// 		Flight flight = flights.getFlight(ticket.getFlight());
	// 		Interval interval =  intervals.getInterval(ticket.getFlight());
	// 		Plane plane = planes.getPlane(flight.getId());
	// 		// FlightInfoView flightInfoView = new FlightInfoView(ticket,flight,plane,interval);
	// 		// System.out.println(flightInfoView.getArriveAirport()+" "+flightInfoView.getArrivePlace());
	// 	}
	// }
}	