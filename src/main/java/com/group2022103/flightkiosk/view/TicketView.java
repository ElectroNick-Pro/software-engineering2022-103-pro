package com.group2022103.flightkiosk.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.group2022103.flightkiosk.controller.TicketController;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.vo.TicketBack;
import com.group2022103.flightkiosk.vo.TicketFront;

public class TicketView {
	/*template begins*/
	private TicketFront ticketFront;
	protected TicketView() {}
	public TicketView(TicketBack ticketBack) {
		/*Bypass backend begins*/
//		var ls = new ArrayList<Ticket>();
//		ls.add(new Ticket() {{
//			this.setBookingId("123123123");
//		}});
		ticketFront = new TicketFront();
//		this.ticketFront.setTickets(ls);
		/*Bypass backend ends*/
		ticketFront = new TicketController().get(ticketBack);
	}
	/*template ends*/
	public boolean isOutOfDate(Ticket ticket) {
		//TODO
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
}
