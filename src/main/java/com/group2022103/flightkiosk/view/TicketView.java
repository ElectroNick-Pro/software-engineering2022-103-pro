package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.List;

import com.group2022103.flightkiosk.controller.TicketController;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.vo.TicketBack;
import com.group2022103.flightkiosk.vo.TicketFront;

public class TicketView {
	private TicketFront ticketFront;
	protected TicketView() {}
	public TicketView(TicketBack ticketBack) {
		ticketFront = new TicketController().get(ticketBack);
	}
	public boolean isCheckIn(Ticket ticket) {
		if(ticket.getIsCheckin() == 0) {
			return false;
		}else {
			return true;
		}
	}
	public boolean isOutOfDate(Ticket ticket) {
		return true;
	}
	public TicketFront getTicketFront() {
		return ticketFront;
	}
	public void setTicketFront(TicketFront ticketFront) {
		this.ticketFront = ticketFront;
	}
	public Ticket getTicket(int i) {
		List<Ticket> tickets = this.getTicketFront().getTickets();
		Ticket ticket = tickets.get(i);
		return ticket;
	}
	public int getTicketNumber(){
		return getTicketFront().getTickets().size();
	}
	public List<String> getTicketId(){
		List<String> ticketId = new ArrayList<>();
		int number = this.getTicketNumber();
		for(int i = 0;i < number;i++) {
			ticketId.add(this.getTicket(i).getId().toString());
		}
		return ticketId;
	}

	public List<String> getFlightId(){
		List<String> flightId = new ArrayList<>();
		int number = this.getTicketNumber();
		for(int i = 0;i < number;i++) {
			flightId.add(this.getTicket(i).getFlight().toString());
		}
		return flightId;
	} 
}
