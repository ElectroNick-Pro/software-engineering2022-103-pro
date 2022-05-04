package com.group2022103.flightkiosk.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group2022103.flightkiosk.component.*;

public class originFoodTests {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.WHITE);
		f.setLayout(null);
		String image = "src/main/resources/image/Standard1.png";
		String name = "Standard";
		double price = 5;
		originFoodUI food = new originFoodUI(image,name,price,1);
		food.setBounds(50,50,200,150);
		f.add(food);
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
//	    f.setLocationRelativeTo(null); 
	    f.setSize(965,550);
		f.setVisible(true);
	}
}
