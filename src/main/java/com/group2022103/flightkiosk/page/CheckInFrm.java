package com.group2022103.flightkiosk.page;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.CheckInView;
import com.group2022103.flightkiosk.view.ConfirmPayView;
import com.group2022103.flightkiosk.view.FlightInfoView;
import com.group2022103.flightkiosk.view.OriginFood;
import com.group2022103.flightkiosk.vo.CheckInBack;
import com.group2022103.flightkiosk.vo.ConfirmPayBack;

public class CheckInFrm extends PageFrm{
	private ImageIcon image;
	private JButton checkIn;
	private FlightInfoView flightInfo;
	private String originFoodName = "";
	private ConfirmPayView confirmPayView = new ConfirmPayView();
	private boolean isGetExtraFood;
    private boolean isGetOriginFood;
    private OriginFood originFood;
    private List<FoodPurchase> allFoodPurchases;
	private Path path = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Check in");
	public CheckInFrm() {
		super();
		setTitleName("Confirm and Print");
		setHintName("Please scan your ID document");
		setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/background0.png")));
		Application.context.getPageConfig().bindPage(this.path, this);
		Application.context.getContext().put("curPath",this.path);
		flightInfo = (FlightInfoView)Application.context.getContext().get("flightInfo");
		originFood = confirmPayView.getOriginFood();
		isGetExtraFood = confirmPayView.isGetExtraFood();
		isGetOriginFood = confirmPayView.isGetOriginFood();
		allFoodPurchases = confirmPayView.getAllFoodPurchases();
		
		add(new BreadCrumbUI(path){{
			setBounds(80,25,800,25);
		}});
		
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
					CheckInView checkInView = new CheckInView(new CheckInBack() {{
						setTicketID(flightInfo.getTicketID());
					}});
//					Seat seat = confirmPayView.getSeatInData();
//	            	confirmPayView = new ConfirmPayView(new ConfirmPayBack(){{
//	            		setFoodChoice(allFoodPurchases);
//	            		setSeat(seat);
//	            	}});
					new PrintFrm().setVisible(true);
				}
			});
		}});
		
		if(isGetOriginFood) {
        	originFoodName = originFood.getName();
        }else if(isGetExtraFood) {
        	originFoodName = "Dessert";
        }else if(! isGetExtraFood && ! isGetOriginFood){
        	originFoodName = "No Food";
        }
		add(new FlightInfoPanelUI(flightInfo.getBookingID(), 
  				flightInfo.getDate(), flightInfo.getAirline(),
  				flightInfo.getDepartPlace(), flightInfo.getArrivePlace(),
          	    flightInfo.getFlightNo(), flightInfo.getDepartureAirport(), flightInfo.getArriveAirport(), 
          	    flightInfo.getDepartureTime(),flightInfo.getArriveTime(),
          	    flightInfo.getLastTime(), "flightSeat", "flightFood", 
          	    flightInfo.getTerminalNo(),flightInfo.getGateNo(),
          	    flightInfo.getUserName(),flightInfo.getUserID()) {{
          	    	checkLayout(confirmPayView.getSeat().getSeatClass(),confirmPayView.getSeat().getSeatNo(),originFoodName);
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
