package com.group2022103.flightkiosk.controller;

import java.time.Duration;
import java.util.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.CustomerMapper;
import com.group2022103.flightkiosk.mapper.IntervalMapper;
import com.group2022103.flightkiosk.mapper.TicketMapper;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.vo.TicketBack;
import com.group2022103.flightkiosk.vo.TicketFront;

public class TicketController {
	
	private TicketMapper ticketMapper = (TicketMapper) Application.context.getMapperConfig().getMappers().get(TicketMapper.class);
	private CustomerMapper customerMapper = (CustomerMapper) Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
	private IntervalMapper intervalMapper = (IntervalMapper) Application.context.getMapperConfig().getMappers().get(IntervalMapper.class);
	
	public TicketFront get(TicketBack req) {
		var res = new TicketFront();
		res.setTickets(new ArrayList<>());
		if(req.getDocumentID() != null) {
			ticketMapper.queryAll().forEach((e)->{
				if(customerMapper.getById(e.getCustomer()).getCustomerId().equals(req.getDocumentID())) {
					res.getTickets().add(e);
				}
			});
		} else if(req.getBookingID() != null) {
			ticketMapper.queryAll().forEach((e)->{
				if(e.getBookingId().equals(req.getBookingID())) {
					res.getTickets().add(e);
				}
			});
		}
		
		var intervalMap = new HashMap<Integer, List<Interval>>(); // FilghtId-Intervals
		for(var interval : intervalMapper.queryAll()) {
			var flightId = interval.getFlight();
			if(!intervalMap.containsKey(flightId)) {
				intervalMap.put(flightId, new ArrayList<>());
			}
			intervalMap.get(flightId).add(interval);
		}
		for(var e: intervalMap.entrySet()) {
			e.getValue().sort((x,y) -> {
				return x.getDepartureTime().compareTo(y.getDepartureTime());
			});
		}
		res.getTickets().sort((x,y)-> {
			var xDep = intervalMap.get(x.getFlight()).get(0).getDepartureTime();
			var yDep = intervalMap.get(y.getFlight()).get(0).getDepartureTime();
			var now = new Date();
			// now = (Date)Application.context.getCsvConfig().getParseMethodMap().get(Date.class).apply("2022-04-03 00:00:00");
			if(xDep.after(now) ^ yDep.after(now)) {
				return yDep.compareTo(xDep);
			} else {
				return Duration.between(xDep.toInstant(), now.toInstant()).abs()
					.compareTo(Duration.between(yDep.toInstant(), now.toInstant()).abs());
			}
		});
		
		return res;
	}

}
