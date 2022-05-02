package com.group2022103.flightkiosk.component;

import javax.swing.*;

import java.awt.*;

public class FlightInfoButtonUI extends JButton{
	private ImageIcon image;
	private JLabel picture, takeoffLabel,arriveLabel,flightNoLabel,dateLabel,
	airlineLabel,departTimeLabel,arriveTimeLabel,timeLabel;

	public FlightInfoButtonUI(String flightTakeoff,String flightArrive,String flightFlightNo,
	String flightDate,String airline,String departTime,String arriveTime,String time){
		var button = this;
		button.setPreferredSize(new Dimension(300, 75));
		button.setBackground(Color.WHITE);
		button.setBorder(new RoundBorderUI()); 
		        
		image = new ImageIcon(ClassLoader.getSystemResource("image/airplane.png"));// background picture
		image.setImage(image.getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));// setSize
		picture=new JLabel(image);

		takeoffLabel = new JLabel(flightTakeoff,JLabel.LEFT){{
			setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
		}};
		arriveLabel = new JLabel(flightArrive,JLabel.RIGHT){{
			setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
		}};
		flightNoLabel = new JLabel(flightFlightNo){{
			setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 12));
		}};
		dateLabel = new JLabel(flightDate,JLabel.RIGHT){{
			setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 12));
		}};
		airlineLabel = new JLabel(airline,JLabel.LEFT){{
			setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		}};
		departTimeLabel = new JLabel(departTime,JLabel.CENTER) {{
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,18));
		}};
		arriveTimeLabel = new JLabel(arriveTime,JLabel.CENTER) {{
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,18));
		}};
		timeLabel = new JLabel("--"+time+"--",JLabel.CENTER) {{
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,14));
			setForeground(Color.GRAY);
		}};
	}
	public void setStyle(){
		ImageIcon expired=new ImageIcon(ClassLoader.getSystemResource("image/expired.png"));
		expired.setImage(expired.getImage().getScaledInstance(100,100, 0));	
		this.setIcon(expired);
		takeoffLabel.setForeground(Color.GRAY);
		arriveLabel.setForeground(Color.GRAY);
		flightNoLabel.setForeground(Color.GRAY);
		airlineLabel.setForeground(Color.GRAY);
		dateLabel.setForeground(Color.GRAY);
		departTimeLabel.setForeground(Color.GRAY);
		arriveTimeLabel.setForeground(Color.GRAY);
   }

	public void buttonLayout() {
		picture.setBounds(175, 7, 50, 50);
		takeoffLabel.setBounds(25, 18, 100, 30);
		arriveLabel.setBounds(270, 18, 100, 30);
		flightNoLabel.setBounds(80, 1, 100, 20);
		dateLabel.setBounds(270, 1, 100, 20);
		airlineLabel.setBounds(25, 1, 100, 20);
		departTimeLabel.setBounds(25,34,80,50);
		arriveTimeLabel.setBounds(270,34,120,50);
		timeLabel.setBounds(160,34,80,50);
		       
		 this.setLayout(null);
		 this.add(picture);
		 this.add(takeoffLabel);
		 this.add(arriveLabel);
		 this.add(flightNoLabel);
		 this.add(dateLabel);
		 this.add(airlineLabel);
		 this.add(departTimeLabel);
		 this.add(arriveTimeLabel);
		 this.add(timeLabel);
	}
}
