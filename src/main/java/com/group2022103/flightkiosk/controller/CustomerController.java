package com.group2022103.flightkiosk.controller;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.CustomerMapper;
import com.group2022103.flightkiosk.mapper.TicketMapper;
import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.vo.*;

public class CustomerController {
	
	private CustomerMapper customerMapper = (CustomerMapper) Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
	private TicketMapper ticketMapper = (TicketMapper) Application.context.getMapperConfig().getMappers().get(TicketMapper.class);
	
	public CustomerFront get(CustomerBack req) {
		var res = new CustomerFront();
		Customer customer = null;
		if(req.getID() > 0) {
			customer = customerMapper.getById(req.getID());
		} else if(req.getCustomerID() != null) {
			for(var c: customerMapper.queryAll()) {
				if(c.getCustomerId().equals(req.getCustomerID())) {
					customer = c;
					break;
				}
			}
		} else if(req.getBookingID() != null) {
			for(var t: ticketMapper.queryAll()) {
				if(t.getBookingId().equals(req.getBookingID())) {
					customer = customerMapper.getById(t.getCustomer());
					break;
				}
			}
		}
		if(customer == null) {
			return null;
		}
		res.setCustomer(customer);
		return res;
	}

}
