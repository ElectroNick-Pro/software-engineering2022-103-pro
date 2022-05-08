package com.group2022103.flightkiosk.controller;

import java.util.HashMap;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.PlaneMapper;
import com.group2022103.flightkiosk.vo.*;

public class PlaneController {
	
	private PlaneMapper planeMapper = (PlaneMapper) Application.context.getMapperConfig().getMappers().get(PlaneMapper.class);
	
	public PlaneFront get(PlaneBack req) {
		var res = new PlaneFront();
		res.setPlanes(new HashMap<>());
		req.getPlaneID().forEach((e)->{
			res.getPlanes().put(Integer.parseInt(e), planeMapper.getById(Integer.parseInt(e)));
		});
		return res;
	}

}
