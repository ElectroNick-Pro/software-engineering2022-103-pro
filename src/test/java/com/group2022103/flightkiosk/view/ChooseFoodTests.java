package com.group2022103.flightkiosk.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group2022103.flightkiosk.page.*;

public class ChooseFoodTests {
	public static void main(String args[]) {
		ChooseFoodFrm f = new ChooseFoodFrm();
		// ExtraFoodFrm f = new ExtraFoodFrm();
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
//	    f.setLocationRelativeTo(null); 
	    f.setSize(965,550);
		f.setVisible(true);
	}
}
