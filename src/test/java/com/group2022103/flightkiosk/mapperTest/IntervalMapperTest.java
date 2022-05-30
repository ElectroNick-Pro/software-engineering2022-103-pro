package com.group2022103.flightkiosk.mapperTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.IntervalMapper;

public class IntervalMapperTest {
	@Test
	public void test() {
		Application.run();
		var mapper = (IntervalMapper) Application.context.getMapperConfig().getMappers().get(IntervalMapper.class);
		var intervals = mapper.queryAll();
		assertTrue(intervals.size() > 0);
	}
}
