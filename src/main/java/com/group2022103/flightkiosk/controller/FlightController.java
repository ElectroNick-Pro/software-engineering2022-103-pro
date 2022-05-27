package com.group2022103.flightkiosk.controller;

import java.util.HashMap;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.FlightMapper;
import com.group2022103.flightkiosk.vo.*;

public class FlightController {
	
	private FlightMapper flightMapper = (FlightMapper) Application.context.getMapperConfig().getMappers().get(FlightMapper.class);
	
	public FlightFront get(FlightBack req) {
		var res = new FlightFront();
		res.setFlights(new HashMap<>());
		req.getFlightID().forEach((e)->{
			res.getFlights().put(Integer.parseInt(e), flightMapper.getById(Integer.parseInt(e)));
		});
		return res;
	}

}
