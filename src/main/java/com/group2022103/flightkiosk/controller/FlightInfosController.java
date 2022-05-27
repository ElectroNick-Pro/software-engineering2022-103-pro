package com.group2022103.flightkiosk.controller;

import java.util.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.CustomerMapper;
import com.group2022103.flightkiosk.mapper.TicketMapper;
import com.group2022103.flightkiosk.vo.FlightInfosBack;
import com.group2022103.flightkiosk.vo.FlightInfosFront;

public class FlightInfosController {
	
	private TicketMapper ticketMapper = (TicketMapper) Application.context.getMapperConfig().getMappers().get(TicketMapper.class);
	private CustomerMapper customerMapper = (CustomerMapper) Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
	
	public FlightInfosFront get(FlightInfosBack req) {
		var res = new FlightInfosFront();
		res.setCustomerMap(new HashMap<>());
		res.setTicketMap(new HashMap<>());
		var customerMap = res.getCustomerMap();
		var ticketMap = res.getTicketMap();
		ticketMapper.queryAll().forEach(e -> {
			if(req.getFlightId() != null && !e.getFlight().equals(req.getFlightId())) {
				return;
			}
			var flightId = e.getFlight();
			if(!customerMap.containsKey(flightId)) {
				customerMap.put(flightId, new HashMap<>());
			}
			customerMap.get(flightId).put(e.getId(), customerMapper.getById(e.getCustomer()));
			if(!ticketMap.containsKey(flightId)) {
				ticketMap.put(flightId, new HashMap<>());
			}
			ticketMap.get(flightId).put(e.getId(), e);
		});
		return res;
	}

}
