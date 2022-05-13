package com.group2022103.flightkiosk.controller;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.TicketMapper;
import com.group2022103.flightkiosk.vo.CheckInBack;
import com.group2022103.flightkiosk.vo.CheckInFront;

public class CheckInController {
	
	private TicketMapper ticketMapper = (TicketMapper) Application.context.getMapperConfig().getMappers().get(TicketMapper.class);
	
	public CheckInFront get(CheckInBack req) {
		var ticket = ticketMapper.getById(req.getTicketID());
		ticket.setIsCheckin(1);
		ticketMapper.update(ticket);
		return new CheckInFront();
	}

}
