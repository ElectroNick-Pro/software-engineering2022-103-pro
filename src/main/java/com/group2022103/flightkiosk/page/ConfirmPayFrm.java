package com.group2022103.flightkiosk.page;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.ConfirmButtonUI;
import com.group2022103.flightkiosk.component.FlightInfoPanelUI;
import com.group2022103.flightkiosk.component.RoundButtonUI;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.ConfirmPayView;
import com.group2022103.flightkiosk.view.SeatChoice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfirmPayFrm extends PageFrm {
	private ConfirmPayView confirmPayView = new ConfirmPayView();
//    private SeatChoice seatChoice = (SeatChoice)Application.context.getContext().get("SeatChoice");
//    private Seat chosenSeat = confirmPayView.getSeat();
    private Double foodPrice = 50.0;
    private Double totalPrice = 100.0;
    

    public ConfirmPayFrm(){
        super();
        
        
        add(new ConfirmButtonUI("src/main/resources/image/cola2.png","Economy Class","A Seat with Extra Space",50,false){{
            setBounds(45, 170,415,90);
        }});
        
        ConfirmButtonUI foodBtn = new ConfirmButtonUI("src/main/resources/image/beer3.png", "Standard","Click to see the details", this.foodPrice, true);
        foodBtn.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FoodChoiceFrm();
            }
        });
        foodBtn.setBounds(45, 260, 415, 85);
        add(foodBtn);

        add(new ConfirmButtonUI("src/main/resources/image/child6.png","Total",this.totalPrice){{
            setBounds(45, 350, 415, 85);
        }});



        add(new FlightInfoPanelUI("flightbookID", "flightDate", "airline","flightTakeoff", "flightArrive",
        	    "flightFlightNo", "flightAirport1", "flightAirport2", "flightStartTime",
        	    "flightArriveTime","time", "flightSeat", "flightFood","12", 
        	    "5"," flightName","fligthNameID") {{
        	    checkLayout("Nomal","6A","sea food");
        	   setBounds(500, 80, 415, 355);
        }});

        setTitleName("Confirm and Pay");
        setHintName("Please check your information and pay the bill:");
		setBackButton();
		setNextButton();

        setTitle("Confirm and Pay");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	    setSize(965,550);
		setVisible(true);
    }

    public void setBackAction() {
		System.out.println("back");
	}
	
	public void setNextAction() {
		System.out.println("next");
	}
	
	public static void main(String args[]) {
		Application.run();
	     ConfirmPayFrm f = new ConfirmPayFrm();
//        FoodChoiceFrm f = new FoodChoiceFrm();
	}
}
