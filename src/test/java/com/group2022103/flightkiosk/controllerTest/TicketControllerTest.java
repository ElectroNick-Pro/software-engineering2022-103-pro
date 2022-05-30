package com.group2022103.flightkiosk.controllerTest;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.TicketController;
import com.group2022103.flightkiosk.vo.TicketBack;

public class TicketControllerTest {
		
	@Test
	public void test() {
		Application.run();
		var para = new TicketBack();
		para.setDocumentID("098765432112345678");
		var ret = new TicketController().get(para).getTickets();
		var retIds = new ArrayList<Integer>();
		ret.forEach(e->retIds.add(e.getId()));
		var cmp = List.of(10,4,11,9);
		// cmp = List.of(4,10,11,9);
		assertArrayEquals(cmp.toArray(), retIds.toArray());
	}

}
