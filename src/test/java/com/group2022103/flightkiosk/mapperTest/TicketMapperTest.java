package com.group2022103.flightkiosk.mapperTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.TicketMapper;

public class TicketMapperTest {
	@Test
	public void test() {
		Application.run();
		var mapper = (TicketMapper) Application.context.getMapperConfig().getMappers().get(TicketMapper.class);
		var tickets = mapper.queryAll();
		assertTrue(tickets.size() > 0);
	}
}
