package com.group2022103.flightkiosk.mapper;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;

public class SeatMapperTest {
	
	@Test
	public void test() {
		Application.run();
		var mapper = (SeatMapper)Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
		var seats = mapper.queryAll();
		assertTrue(seats.size() > 0);
	}

}
