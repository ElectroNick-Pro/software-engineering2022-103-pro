package com.group2022103.flightkiosk.page;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
		addExitButton();
		addHelpButton();
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
		
		image = new ImageIcon(ClassLoader.getSystemResource("image/scanIDcard.png"));
		image.setImage(image.getImage().getScaledInstance(350,200,Image.SCALE_DEFAULT));
		JLabel picture;
		picture=new JLabel(image);
		picture.setBounds(30,180,350,200);
		add(picture);
		
		add(new RoundButtonUI("Check In", new Color(0,131,255), new Color(0,105,206)) {{
			setForeground(Color.WHITE);
			setBounds(50,400,360,30);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CheckInView(new CheckInBack() {{
						setTicketID(flightInfo.getTicketID());
					}});

					ConfirmPayView confirmPayView = new ConfirmPayView();
					Seat seat = confirmPayView.getSeatInData();
					confirmPayView = new ConfirmPayView(new ConfirmPayBack(){{
						setFoodChoice(allFoodPurchases);
						setSeat(seat);
					}});	
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

	public void setExitAction(){
		JOptionPane.showMessageDialog(null, "You can not exit the system before checking in.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
