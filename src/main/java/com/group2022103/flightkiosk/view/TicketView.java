package com.group2022103.flightkiosk.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		var ls = new ArrayList<Ticket>();
		ls.add(new Ticket() {{
			this.setBookingId("123123123");
		}});
		ticketFront = new TicketFront();
		this.ticketFront.setTickets(ls);
		/*Bypass backend ends*/
		// setTicketFront(new TicketController().getTicket(ticketBack));
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
}
