package com.group2022103.flightkiosk.viewTest;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.vo.*;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Ticket;
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
		PlaneView planeView = new PlaneView(new PlaneBack() {{
			setPlaneID(flightView.getPlaneID());
		}});
		assertEquals(3,planeView.getPlaneFront().getPlanes().size());
		IntervalView intervalView = new IntervalView(new IntervalBack() {{
			setFlightID(flightView.getFlightID());
		}});
		assertEquals(3,intervalView.getIntervalFront().getIntervals().size());
		testGetAllInfo(ticketView,flightView,intervalView,planeView);
	}
	public void testGetAllInfo(TicketView tickets,FlightView flights,IntervalView intervals,
			PlaneView planes) {
		int num = tickets.getTicketNumber();
		for(int i = 0; i < num;i++) {
			Ticket ticket = tickets.getTicket(i);
			Flight flight = flights.getFlight(ticket.getFlight());
			Interval interval =  intervals.getInterval(ticket.getFlight());
			Plane plane = planes.getPlane(flight.getId());
			// FlightInfoView flightInfoView = new FlightInfoView(ticket,flight,plane,interval);
			// System.out.println(flightInfoView.getArriveAirport()+" "+flightInfoView.getArrivePlace());
		}
	}
}	