package com.group2022103.flightkiosk.view;

import javax.swing.JFrame;

import com.group2022103.flightkiosk.page.*;	

public class RetrieveTests {
	public static void main(String args[]) {
		RetrieveFrm f = new RetrieveFrm();
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
//	    f.setLocationRelativeTo(null); 
	    f.setSize(965,550);
		f.setVisible(true);
	}
}