package com.group2022103.flightkiosk.controller;

import java.util.HashMap;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.AirlineMapper;
import com.group2022103.flightkiosk.vo.AirlineBack;
import com.group2022103.flightkiosk.vo.AirlineFront;

public class AirlineController {
	
	private AirlineMapper airlineMapper = (AirlineMapper) Application.context.getMapperConfig().getMappers().get(AirlineMapper.class);
	
	public AirlineFront get(AirlineBack req) {
		var res = new AirlineFront();
		res.setAirlines(new HashMap<>());
		req.getAirlineID().forEach(e->{
			res.getAirlines().put(e, airlineMapper.getById(e));
		});
		return res;
	}

}
