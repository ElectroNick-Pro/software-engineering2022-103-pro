package com.group2022103.flightkiosk.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class FlightBackButtonUI extends JButton{
	private JLabel flightNoLabel,departPlaceLabel,destinationLabel,dateLabel;
	public FlightBackButtonUI(String flightNo, String departPlace,String destination,String date){
		var button = this;
		button.setPreferredSize(new Dimension(836, 56));
		button.setBackground(Color.WHITE);
		button.setBorder(new RoundBorderUI(Color.gray)); 
		flightNoLabel = new JLabel(flightNo) {{
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		}};
		departPlaceLabel = new JLabel(departPlace) {{
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		}};
		destinationLabel = new JLabel(destination) {{
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		}};
		dateLabel = new JLabel(date) {{
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		}};
	}
	public void buttonLayout() {
		flightNoLabel.setBounds(10,8,100,40);
		departPlaceLabel.setBounds(180,8,200,40);
		destinationLabel.setBounds(450,8,200,40);
		dateLabel.setBounds(680,8,150,40);
		
		this.setLayout(null);
		this.add(flightNoLabel);
		this.add(departPlaceLabel);
		this.add(destinationLabel);
		this.add(dateLabel);	
	}
}
