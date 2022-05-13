package com.group2022103.flightkiosk.page;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.controller.ConfirmPayController;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.ConfirmPayView;
import com.group2022103.flightkiosk.view.FlightInfoView;
import com.group2022103.flightkiosk.view.OriginFood;
import com.group2022103.flightkiosk.view.SeatChoice;
import com.group2022103.flightkiosk.vo.ConfirmPayBack;
import com.group2022103.flightkiosk.vo.ConfirmPayFront;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class ConfirmPayFrm extends PageFrm {
	private ConfirmPayView confirmPayView;
	private ConfirmPayBack confirmPayBack;
	private ConfirmPayFront confirmPayFront;
	private FlightInfoView flightInfo;
    private Seat chosenSeat;
    private OriginFood originFood;
    private String originFoodName = "";
    private ArrayList<OriginFood> allFoodChoice;
    private List<FoodPurchase> allFoodPurchases;
    private boolean isGetExtraFood;
    private boolean isGetOriginFood;
    private Double foodPrice;
    private Double totalPrice;
    private Path path = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay");
    
    public ConfirmPayFrm(){
        super();
        Application.context.getPageConfig().bindPage(this.path, this);
        Application.context.getContext().put("curPath",this.path);
        ConfirmPayView confirmPayView = new ConfirmPayView();
        flightInfo = (FlightInfoView)Application.context.getContext().get("flightInfo");
        
        add(new BreadCrumbUI(path){{
			setBounds(80,25,800,25);
		}});
        
        chosenSeat = confirmPayView.getSeat();
        allFoodPurchases = confirmPayView.getAllFoodPurchases();
        originFood = confirmPayView.getOriginFood();
        allFoodChoice = confirmPayView.getAllFoodChoice();
        isGetExtraFood = confirmPayView.isGetExtraFood();
        isGetOriginFood = confirmPayView.isGetOriginFood();
        foodPrice = confirmPayView.getFoodPrice();
        totalPrice = confirmPayView.getTotalPrice();
        
        System.out.println("food number: "+allFoodChoice.size());
        
        
        String seatClass = "";
        String seatType = "";
        if (chosenSeat.getSeatClass().equals("Normal")) {
        	seatClass = "Economy Class";
        } else if (chosenSeat.getSeatClass().equals("First")) {
        	seatClass = "First Class";
        }
        if (chosenSeat.getType().equals("Normal") || chosenSeat.getType().equals("Window") || chosenSeat.getType().equals("Aisle")) {
        	seatType = chosenSeat.getType() + " Seat";
        } else if (chosenSeat.getType().equals("Extra")) {
        	seatType = "A Seat with Extra Space";
        }
        
        add(new ConfirmButtonUI("src/main/resources/image/seat1.png",seatClass,seatType,chosenSeat.getPrice(),false){{
            setBounds(45, 170,415,90);
        }});
        
        ConfirmButtonUI foodBtn = new ConfirmButtonUI("src/main/resources/image/beer3.png", "Standard","Click to see the details", this.foodPrice, true);
        if(isGetOriginFood) {
        	if(isGetExtraFood) {
            	foodBtn = new ConfirmButtonUI("src/main/resources/image/knife and fork0.png", "Food","Click to see the details", this.foodPrice, true);
            }else {
            	foodBtn = new ConfirmButtonUI(originFood.getImage(), originFood.getName(), this.foodPrice);
            }
        }else {
        	if(! isGetExtraFood) {
        		foodBtn = new ConfirmButtonUI("src/main/resources/image/knife and fork0.png", "Nothing", this.foodPrice);
        	}else {
        		if(allFoodChoice.size() == 1) {
        			foodBtn = new ConfirmButtonUI(allFoodChoice.get(0).getImage(), allFoodChoice.get(0).getName(), this.foodPrice);
        		}else {
        			foodBtn = new ConfirmButtonUI("src/main/resources/image/Dessert0.png", "Dessert","Click to see the details", this.foodPrice, true);
        		}
        	}
        }
        
        foodBtn.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FoodChoiceFrm(allFoodChoice){{
                    setLocationRelativeTo(null);
                }};
            }
        });
        foodBtn.setBounds(45, 260, 415, 85);
        add(foodBtn);

        add(new ConfirmButtonUI("src/main/resources/image/pay1.png","Total",this.totalPrice){{
            setBounds(45, 350, 415, 85);
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
        	    checkLayout(chosenSeat.getSeatClass(),chosenSeat.getSeatNo(),originFoodName);
        	   setBounds(500, 80, 415, 355);
        }});

        setTitle("Confirm and Pay");
        setTitleName("Confirm and Pay");
        setHintName("Please check your information and pay the bill:");
		setBackButton();
		setNextButton();

    }

	public void setNextAction() {
		System.out.println("next");
        if(totalPrice == 0.0){
            try {
            	confirmPayView = new ConfirmPayView();
            	Seat seat = confirmPayView.getSeatInData();
            	confirmPayView = new ConfirmPayView(new ConfirmPayBack(){{
            		setFoodChoice(allFoodPurchases);
            		setSeat(seat);
            	}});
                new CheckInFrm();
                Application.context.getPageConfig().displayPage(path.resolve(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Check in")));
            } catch (UnboundPageException e1) {
                e1.printStackTrace();
                return;
            }
        }else{
            new PaymentFrm().setVisible(true);
        }
	}
	
	public static void main(String args[]) {
		Application.run();
//	    ConfirmPayFrm f = new ConfirmPayFrm();
//      FoodChoiceFrm f = new FoodChoiceFrm();
	}
}
