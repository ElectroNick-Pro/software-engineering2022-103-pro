package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.controller.CheckInController;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.vo.CheckInBack;

public class CheckInView {
	private int ticketID;
	
	public CheckInView(CheckInBack checkInBack) {
		new CheckInController().get(checkInBack);
	}
}
