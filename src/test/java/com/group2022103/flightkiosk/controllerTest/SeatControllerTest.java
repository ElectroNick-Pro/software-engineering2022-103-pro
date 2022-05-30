package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.*;
import com.group2022103.flightkiosk.mapper.*;
import com.group2022103.flightkiosk.vo.*;

public class SeatControllerTest {
    private SeatMapper SeatMapper;
	
	@Test
	public void SeatControllerTests() {
		Application.run();
		SeatMapper = (SeatMapper) Application.context.getMapperConfig().getMappers().get(SeatMapper.class);
		var para = new SeatBack(){{
            setTicketId(-1);
        	setIntervalId(3);
        	setSeatId(-1);
        }};
		int ret = new SeatController().get(para).getSeats().get(0).getId();
		assertEquals(113, ret);
	}
}
