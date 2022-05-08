package com.group2022103.flightkiosk.page;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.FlightInfoPanelUI;
import com.group2022103.flightkiosk.component.RoundButtonUI;

public class CheckInFrm extends PageFrm{
	private ImageIcon image;
	private JButton checkIn;
	private Path path = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Check in");
	public CheckInFrm() {
		super();
		setTitleName("Confirm and Print");
		setHintName("Please scan your ID document");
		setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/background0.png")));
		Application.context.getPageConfig().bindPage(this.path, this);
		
		image = new ImageIcon(ClassLoader.getSystemResource("image/scanIDcard.png"));// background picture
		image.setImage(image.getImage().getScaledInstance(350,200,Image.SCALE_DEFAULT));// setSize
		JLabel picture;
		picture=new JLabel(image);
		picture.setBounds(30,180,350,200);
		add(picture);
		
		add(checkIn = new RoundButtonUI("Check In", new Color(0,131,255), new Color(0,105,206)) {{
			setForeground(Color.WHITE);
			setBounds(50,400,360,30);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new PrintFrm().setVisible(true);
				}
			});
		}});
		add(new FlightInfoPanelUI("flightbookID", "flightDate", "airline","flightTakeoff", "flightArrive",
        	    "1234", "flightAirport1", "flightAirport2", "flightStartTime",
        	    "flightArriveTime","time", "flightSeat", "flightFood","12", 
        	    "5"," flightName","fligthNameID"){{
        	    checkLayout("Nomal","6A","sea food");
             	setBounds(490, 80, 415, 355);
		}});
		
	}
	public static void main(String[] args) {
		CheckInFrm f = new CheckInFrm();
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	    f.setSize(965,550);
		f.setVisible(true);
	}
}
