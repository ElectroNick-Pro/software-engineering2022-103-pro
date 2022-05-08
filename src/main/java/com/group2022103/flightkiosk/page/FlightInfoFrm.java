package com.group2022103.flightkiosk.page;

import javax.swing.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.DemoScrollBarUI;
import com.group2022103.flightkiosk.component.FlightInfoButtonUI;
import com.group2022103.flightkiosk.component.FlightInfoPanelUI;
import com.group2022103.flightkiosk.component.RoundBorderUI;
import com.group2022103.flightkiosk.view.TicketView;
import com.group2022103.flightkiosk.vo.TicketBack;

import java.awt.*;
import java.nio.file.Path;

public class FlightInfoFrm extends PageFrm{
	private Path path = Path.of("/Retrieve/Flight Information");
	private TicketView ticketView = new TicketView(new TicketBack() {{
		setSurname("");
		setDocumentID("");
	}});
	private JPanel buttonPane;
	public FlightInfoFrm() {
		super();
		setTitleName("Flight Information");
		setHintName("Please choose the flight and check the information:");
		setBackButton();
		setNextButton();
		setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/background0.png")));
		Application.context.getPageConfig().bindPage(this.path, this);
        
		//add button of all the ticket he or she have
		int NUM = 4;//Number of tickets
        buttonPane = new JPanel() {{
        	setBackground(Color.white);
        	setBorder(new RoundBorderUI());
        	setLayout(new GridLayout(NUM,1) {{
        		setVgap(10);
        	}});
        }};
        FlightInfoButtonUI[] button = new FlightInfoButtonUI[NUM];//create buttons
        for(int i = 0; i < NUM; i++) {
        	//TODO
        	button[i] = new FlightInfoButtonUI("SHANG","Beijing","2022",
        			"March 4","AirChina","16:00","18:05","2h5min");
        	//TODO
        	if(i > 1) {
        		button[i].setStyle();
        	}
            button[i].buttonLayout();
            button[i].setBorder(BorderFactory.createCompoundBorder(button[i].getBorder(), BorderFactory.createEmptyBorder(20, 20, 20, 20))); 
            buttonPane.add(button[i]);
        }
        add(new JScrollPane(buttonPane) {{
        	setBackground(Color.white);
        	setBounds(35,170,420,250);
        	getVerticalScrollBar().setUI(new DemoScrollBarUI());
        }});
        
        add(new FlightInfoPanelUI("flightbookID", "flightDate", "airline","flightTakeoff", "flightArrive",
        	    "1234", "flightAirport1", "flightAirport2", "flightStartTime",
        	    "flightArriveTime","time", "flightSeat", "flightFood","12", 
        	    "5"," flightName","fligthNameID") {{
        	   checkLayout("Nomal","6A","sea food");
        	   setBounds(500, 80, 415, 355);
        }});
        
	}
	public void setBackAction() {
		System.out.println("back");
	}
	
	public void setNextAction() {
		System.out.println("next");
	}
	public static void main(String[] args) {
		FlightInfoFrm f = new FlightInfoFrm();
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	    f.setSize(965,550);
		f.setVisible(true);
	}
}