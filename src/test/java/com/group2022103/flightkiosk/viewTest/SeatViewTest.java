package com.group2022103.flightkiosk.viewTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.nio.channels.NonWritableChannelException;
import java.sql.Date;
import java.util.List;

import javax.swing.plaf.ColorUIResource;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.SeatController;
import com.group2022103.flightkiosk.mapper.*;
import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.view.AirlineView;
import com.group2022103.flightkiosk.view.CustomerView;
import com.group2022103.flightkiosk.view.FlightInfoView;
import com.group2022103.flightkiosk.view.FlightView;
import com.group2022103.flightkiosk.view.IntervalView;
import com.group2022103.flightkiosk.view.PlaneView;
import com.group2022103.flightkiosk.view.SeatView;
import com.group2022103.flightkiosk.view.TicketView;
import com.group2022103.flightkiosk.vo.AirlineBack;
import com.group2022103.flightkiosk.vo.CustomerBack;
import com.group2022103.flightkiosk.vo.FlightBack;
import com.group2022103.flightkiosk.vo.IntervalBack;
import com.group2022103.flightkiosk.vo.PlaneBack;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;
import com.group2022103.flightkiosk.vo.TicketBack;

public class SeatViewTest {
	private FlightInfoView flightInfo;
	@Test
	public void test() {
		dataInit();
		Application.run();
		Application.context.getContext().put("flightInfo",flightInfo);
		 SeatBack seatBack = new SeatBack(){{
		 	setTicketId(-1);
		 	setSeatId(1);
		 	setIntervalId(-1);
		 }};
		 SeatView seatView = new SeatView(seatBack);
		 SeatFront seatFront = new SeatController().get(seatBack);
		 List<Seat> seats = seatView.getSeatFront();
		 assertEquals(seats.get(0).getSeatNo(), "1A");
		 assertEquals(seatView.getRowLength(), 13);
		 assertEquals(seatView.getColumnLength(), 6);
		
		ColorUIResource[] color = new ColorUIResource[2];
		color[0] = new ColorUIResource(249,237,166);
		color[1] = new ColorUIResource(205,205,205);
		 assertEquals(seatView.getButtonColor(), color);
		
		 assertEquals(seatView.canChooseSeat(), true);
		 assertEquals(seatView.getSeatStatus(), 0);
		 assertEquals(seatView.getAllSeats(), seatView.getSeatFront());
		
	}
	
	public void dataInit() {
		Ticket ticket = new Ticket();
		ticket.setId(3);
		ticket.setCustomer(1);
		ticket.setFlight(3);
		ticket.setBookingId("BK1101");
		ticket.setCounterNo("1232123");
		ticket.setIsCheckin(0);
		ticket.setLuggageCnt(2);
		ticket.setSeatClass("Normal");
		
  		Flight flight = new Flight();
  		flight.setId(3);
  		flight.setFlightNo("231451");
  		flight.setPlane(3);
  		
  		Plane plane = new Plane();
  		plane.setId(3);
  		plane.setAirline(1);
  		plane.setColumnLength(6);
  		plane.setRowLength(13);
  		plane.setType("PlaneTypeOne");
  		
  		Interval interval = new Interval();
  		interval.setId(3);
  		interval.setDepartureAirport("Jinwan Airport");
  		interval.setDepartureCity("Zhuhai");
  		interval.setDepartureTime(new java.util.Date());
  		interval.setDestAirport("Taiping Airport");
  		interval.setDestCity("Harbin");
  		interval.setFlight(3);
  		interval.setDestTime(new java.util.Date());
  		interval.setGate("34");
  		interval.setTerminal("2");
  		
  		Airline airline = new Airline();
  		airline.setId(1);
  		airline.setName("AirOne");
  		
  		Customer customer = new Customer();
  		customer.setId(1);
  		customer.setCreditId("4001234567");
  		customer.setCustomerId("123456789012345678");
  		customer.setFirstname("Yunuo");
  		customer.setPassword("f5bb0c8de146c67b44babbf4e6584cc0");
  		customer.setSurname("Wang");
  		
  		flightInfo = new FlightInfoView(ticket,flight,plane,interval,airline,customer);
	}
}
