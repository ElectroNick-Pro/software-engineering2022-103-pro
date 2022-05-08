package com.group2022103.flightkiosk.page;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.ConfirmButtonUI;
import com.group2022103.flightkiosk.component.FlightInfoPanelUI;
import com.group2022103.flightkiosk.component.RoundButtonUI;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.ConfirmPayView;
import com.group2022103.flightkiosk.view.SeatChoice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;


public class ConfirmPayFrm extends PageFrm {
	private ConfirmPayView confirmPayView = new ConfirmPayView();
//    private SeatChoice seatChoice = (SeatChoice)Application.context.getContext().get("SeatChoice");
//    private Seat chosenSeat = confirmPayView.getSeat();
    private Double foodPrice = 50.0;
    private Double totalPrice = 100.0;
    private Path path = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay");
    
    public ConfirmPayFrm(){
        super();
        Application.context.getPageConfig().bindPage(this.path, this);
        
        add(new ConfirmButtonUI("src/main/resources/image/cola2.png","Economy Class","A Seat with Extra Space",50,false){{
            setBounds(45, 170,415,90);
        }});
        
        ConfirmButtonUI foodBtn = new ConfirmButtonUI("src/main/resources/image/beer3.png", "Standard","Click to see the details", this.foodPrice, true);
        foodBtn.confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FoodChoiceFrm(){{
                    setLocationRelativeTo(null);
                }};
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

        setTitle("Confirm and Pay");
        setTitleName("Confirm and Pay");
        setHintName("Please check your information and pay the bill:");
		setBackButton();
		setNextButton();

    }

    public void setBackAction() {
		System.out.println("back");
	}
	
	public void setNextAction() {
		System.out.println("next");
        if(totalPrice == 0.0){
            try {
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
	    ConfirmPayFrm f = new ConfirmPayFrm();
//      FoodChoiceFrm f = new FoodChoiceFrm();
	}
}
