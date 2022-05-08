package com.group2022103.flightkiosk.controller;

import java.util.ArrayList;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.SeatMapper;
import com.group2022103.flightkiosk.vo.*;

public class SeatController {
	
	private SeatMapper seatMapper = (SeatMapper) Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
	
	public SeatFront get(SeatBack req) {
		var res = new SeatFront();
		res.setSeats(new ArrayList<>());
		if(req.getTicketId() > 0) {
			seatMapper.queryAll().forEach((e)->{
				if(e.getTicket().equals(req.getTicketId())) {
					res.getSeats().add(e);
				}
			});
			return res;
		}
		if(req.getIntervalId() > 0) {
			seatMapper.queryAll().forEach((e)->{
				if(e.getInterval().equals(req.getIntervalId())) {
					res.getSeats().add(e);
				}
			});
			return res;
		}
		if(req.getSeatId() > 0) {
			res.getSeats().add(seatMapper.getById(req.getSeatId()));
			return res;
		}
		return res;
	}

}
