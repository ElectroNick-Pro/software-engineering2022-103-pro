package com.group2022103.flightkiosk.controller;

import java.util.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.IntervalMapper;
import com.group2022103.flightkiosk.vo.*;

public class IntervalController {
	
	private IntervalMapper intervalMapper = (IntervalMapper) Application.context.getMapperConfig().getMappers().get(IntervalMapper.class);
	
	public IntervalFront get(IntervalBack req) {
		var res = new IntervalFront();
		res.setIntervals(new HashMap<>());
		if(req.getFlightID() == null) {
			intervalMapper.queryAll().forEach(e->{
				if(!res.getIntervals().containsKey(e.getFlight())) {
					res.getIntervals().put(e.getFlight(), new ArrayList<>());
				}
				res.getIntervals().get(e.getFlight()).add(e);
			});
		} else {
			var m = Set.copyOf(req.getFlightID());
			intervalMapper.queryAll().forEach(e->{
				if(m.contains(e.getFlight().toString())) {
					if(!res.getIntervals().containsKey(e.getFlight())) {
						res.getIntervals().put(e.getFlight(), new ArrayList<>());	
					}
					res.getIntervals().get(e.getFlight()).add(e);
				}
			});
		}
		return res;
	}

}
