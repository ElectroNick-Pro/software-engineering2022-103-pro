package com.group2022103.flightkiosk;

import javax.swing.JFrame;

import com.group2022103.flightkiosk.page.ChooseSeatFrm;

import org.junit.Test;

public class FlightKioskTests {
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void chooseSeatTest(){
		ChooseSeatFrm seatFrame =  new ChooseSeatFrm();
		seatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seatFrame.setResizable(false);
	    seatFrame.setSize(965,550);
		seatFrame.setVisible(true);
	}
}
