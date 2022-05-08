package com.group2022103.flightkiosk.controller;

import java.util.ArrayList;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.FoodMapper;
import com.group2022103.flightkiosk.vo.*;

public class FoodController {
	
	private FoodMapper foodMapper = (FoodMapper) Application.context.getMapperConfig().getMappers().get(FoodMapper.class);
	
	public FoodFront get(FoodBack req) {
		var res = new FoodFront();
		res.setExtraFood(new ArrayList<>());
		res.setOriginFood(new ArrayList<>());
		foodMapper.queryAll().forEach((e)->{
			if(e.getFlight().equals(req.getFlightId())) {
				switch(e.getType()) {
				case "Origin":
					res.getOriginFood().add(e);
					break;
				case "Extra":
					res.getExtraFood().add(e);
					break;
				default:
					break;
				}
			}
		});
		return res;
	}

}
