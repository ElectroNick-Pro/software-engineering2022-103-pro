package com.group2022103.flightkiosk;

import static org.junit.Assert.assertEquals;

import javax.swing.JFrame;

import com.group2022103.flightkiosk.page.ChooseSeatFrm;
import com.group2022103.flightkiosk.view.SeatView;

import org.junit.Test;

public class FlightKioskTests {
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void chooseSeatTest(){
		ChooseSeatFrm seatFrame =  new ChooseSeatFrm();
		// SeatView seatService = new SeatView(1);
		// assertEquals(1, seatService.getSeatId());
		seatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seatFrame.setResizable(false);
	    seatFrame.setSize(965,550);
		seatFrame.setVisible(true);
	}
}
