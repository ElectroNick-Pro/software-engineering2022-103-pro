package com.group2022103.flightkiosk.controller;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.CustomerMapper;
import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.vo.*;

public class CustomerController {
	
	private CustomerMapper customerMapper = (CustomerMapper) Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
	
	public CustomerFront get(CustomerBack req) {
		var res = new CustomerFront();
		Customer customer = null;
		if(req.getID() > 0) {
			customer = customerMapper.getById(res.getID());
		} else if(req.getCustomerID() != null) {
			for(var c: customerMapper.queryAll()) {
				if(c.getCustomerId().equals(req.getCustomerID())) {
					customer = c;
					break;
				}
			}
		}
		if(customer == null) {
			return null;
		}
		res.setCreditID(customer.getCreditId());
		res.setPassword(customer.getPassword());
		res.setSurname(customer.getSurname());
		res.setCustomerID(customer.getCustomerId());
		res.setFirstName(customer.getFirstname());
		res.setID(customer.getId());
		return res;
	}

}
