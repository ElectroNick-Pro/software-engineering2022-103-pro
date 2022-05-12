package com.group2022103.flightkiosk.mapperTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.mapper.CustomerMapper;

public class CustomerMapperTest {
	
	@Test
	public void test() {
		Application.run();
		var mapper = (CustomerMapper)Application.context.getMapperConfig().getMappers().get(CustomerMapper.class);
		var obj = mapper.getById(1);
		assertEquals(1, obj.getId().intValue());
	}

}
