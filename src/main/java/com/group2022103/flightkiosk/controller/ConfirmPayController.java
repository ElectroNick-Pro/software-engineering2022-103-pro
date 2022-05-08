package com.group2022103.flightkiosk.controller;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.FoodPurchaseMapper;
import com.group2022103.flightkiosk.mapper.SeatMapper;
import com.group2022103.flightkiosk.vo.*;

public class ConfirmPayController {
	
	private FoodPurchaseMapper foodChoiceMapper = (FoodPurchaseMapper)Application.context.getMapperConfig().getMappers().get(FoodPurchaseMapper.class);
	private SeatMapper seatMapper = (SeatMapper)Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
	
	public ConfirmPayFront get(ConfirmPayBack req) {
		req.getFoodChoice().forEach(foodChoiceMapper::update);
		seatMapper.update(req.getSeat());
		return new ConfirmPayFront();
	}

}
