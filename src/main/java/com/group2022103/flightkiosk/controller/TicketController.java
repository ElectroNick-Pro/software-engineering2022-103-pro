package com.group2022103.flightkiosk.controller;

import java.util.ArrayList;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.CustomerMapper;
import com.group2022103.flightkiosk.mapper.TicketMapper;
import com.group2022103.flightkiosk.vo.TicketBack;
import com.group2022103.flightkiosk.vo.TicketFront;

public class TicketController {
	
	private TicketMapper ticketMapper = (TicketMapper) Application.context.getMapperConfig().getMappers().get(TicketMapper.class);
	private CustomerMapper customerMapper = (CustomerMapper) Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
	
	public TicketFront get(TicketBack req) {
		var res = new TicketFront();
		res.setTickets(new ArrayList<>());
		if(req.getDocumentID() != null) {
			ticketMapper.queryAll().forEach((e)->{
				if(customerMapper.getById(e.getCustomer()).getCustomerId().equals(req.getDocumentID())) {
					res.getTickets().add(e);
				}
			});
			return res;
		}
		if(req.getBookingID() != null) {
			ticketMapper.queryAll().forEach((e)->{
				if(e.getBookingId().equals(req.getBookingID())) {
					res.getTickets().add(e);
				}
			});
		}
		return res;
	}

}
