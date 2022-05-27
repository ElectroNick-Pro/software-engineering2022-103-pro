package com.group2022103.flightkiosk.vo;

import java.util.*;

import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.model.Ticket;

public class FlightInfosFront {

	// FlightId-Map{TicketId-isCheckIn}
	private Map<Integer, Map<Integer, Ticket>> ticketMap;
	// FlightId-Map{TicketId-Customer}
	private Map<Integer, Map<Integer, Customer>> customerMap;

	public Map<Integer, Map<Integer, Ticket>> getTicketMap() {
		return ticketMap;
	}
	public void setTicketMap(Map<Integer, Map<Integer, Ticket>> ticketMap) {
		this.ticketMap = ticketMap;
	}
	public Map<Integer, Map<Integer, Customer>> getCustomerMap() {
		return customerMap;
	}
	public void setCustomerMap(Map<Integer, Map<Integer, Customer>> customerMap) {
		this.customerMap = customerMap;
	}
	
}
