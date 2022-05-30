package com.group2022103.flightkiosk.viewTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.view.ConfirmPayView;
import com.group2022103.flightkiosk.view.FlightInfoView;
import com.group2022103.flightkiosk.view.OriginFood;
import com.group2022103.flightkiosk.view.SeatChoice;

public class ConfirmPayViewTest {
	private FlightInfoView flightInfo;
	@Test
	public void test() {
		dataInit();
		Application.run();
		Application.context.getContext().put("flightInfo",flightInfo);
		ConfirmPayView confirmPayView = new ConfirmPayView();
		SeatChoice seatChoice = new SeatChoice(1, 1, 1, 1, 1, "1A", "First", 100.0, "Normal", true);
        Application.context.getContext().put("SeatChoice", seatChoice);
        Seat seat = new Seat();
        seat.setId(1);
        seat.setInterval(1);
        seat.setColumnNo(1);
        seat.setRowNo(1);
        seat.setPrice(100.0);
        seat.setSeatClass("First");
        seat.setSeatNo("1A");
        seat.setTicket(1);
        seat.setType("Normal");
        assertEquals(confirmPayView.getSeat().getId(), seat.getId());
        assertEquals(confirmPayView.getSeatInData().getId(), seat.getId());
        
        Application.context.getContext().put("OriginFood",new OriginFood(1,"","Food",10.0,1));
        assertEquals(confirmPayView.getOriginFood().getFoodID(), 1);
        assertEquals(confirmPayView.isGetOriginFood(), true);
        
        ArrayList<OriginFood> ExtraFood = new ArrayList<OriginFood>();
        for(int i=0;i<3;i++){
			ExtraFood.add(new OriginFood(i+1,"", "Food "+i+1, 5.0, i+1));
		}
		Application.context.getContext().put("ExtraFood",ExtraFood);
		assertEquals(confirmPayView.isGetExtraFood(), true);
		
		ArrayList<OriginFood> allFood = new ArrayList<OriginFood>();
		allFood.add(new OriginFood(1,"","Food",10.0,1));
		allFood.add(ExtraFood.get(0));
		allFood.add(ExtraFood.get(1));
		allFood.add(ExtraFood.get(2));
		assertEquals(confirmPayView.getAllFoodChoice().size(), allFood.size());
		
		Double foodPrice = 0.0;
		foodPrice = foodPrice + 10.0;
		for(int i = 0; i < ExtraFood.size(); i ++) {
			foodPrice = foodPrice + ExtraFood.get(i).getPrice() * ExtraFood.get(i).getCount();
		}
		assertSame(confirmPayView.getAllFoodPurchases().get(1).getFood(), ExtraFood.get(0).getFoodID());
		assertEquals(confirmPayView.getFoodPrice(), foodPrice);
		Double totalPrice = foodPrice + seat.getPrice();
		assertEquals(confirmPayView.getTotalPrice(), totalPrice);
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
