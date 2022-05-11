package com.group2022103.flightkiosk.mapperTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.SeatMapper;

public class SeatMapperTest {
	
	@Test
	public void test() {
		Application.run();
		var mapper = (SeatMapper)Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
		var seats = mapper.queryAll();
		assertTrue(seats.size() > 0);
	}

}
