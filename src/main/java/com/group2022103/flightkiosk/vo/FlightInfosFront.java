package com.group2022103.flightkiosk.vo;

import java.util.*;

import com.group2022103.flightkiosk.model.Customer;

public class FlightInfosFront {
	// FlightId-Map{TicketId-isCheckIn}
	private Map<Integer, Map<Integer, Integer>> ticketMap;
	// FlightId-Map{TicketId-Customer}
	private Map<Integer, Map<Integer, Customer>> customerMap;
	public Map<Integer, Map<Integer, Integer>> getTicketMap() {
		return ticketMap;
	}
	public void setTicketMap(Map<Integer, Map<Integer, Integer>> ticketMap) {
		this.ticketMap = ticketMap;
	}
	public Map<Integer, Map<Integer, Customer>> getCustomerMap() {
		return customerMap;
	}
	public void setCustomerMap(Map<Integer, Map<Integer, Customer>> customerMap) {
		this.customerMap = customerMap;
	}
	
}
