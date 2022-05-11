package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.event.*; 

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Ticket;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import java.awt.*;
import java.nio.file.Path;

public class FlightInfoFrm extends PageFrm{
	private Path path = Path.of("/Retrieve/Flight Information");
	private TicketView ticketView = new TicketView(new TicketBack() {{
		setSurname("");
		setDocumentID("123456789012345678");
		setBookingID("");
	}});
	private FlightView flightView = new FlightView(new FlightBack() {{
		setFlightID(ticketView.getTicketId());
	}});
	private PlaneView planeView = new PlaneView(new PlaneBack() {{
		setPlaneID(flightView.getPlaneID());
	}});
	private IntervalView intervalView = new IntervalView(new IntervalBack() {{
		setFlightID(flightView.getFlightID());
	}});
	private AirlineView airlineView = new AirlineView(new AirlineBack() {{
		setAirlineID(planeView.getAirlineId());
	}});
	private JPanel buttonPane;
	private JPanel rightPanel;
	private int chooseTicket;
	public FlightInfoFrm() {
		super();
		setTitleName("Flight Information");
		setHintName("Please choose the flight and check the information:");
		setBackButton();
		setNextButton();
		setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/background0.png")));
		Application.context.getPageConfig().bindPage(this.path, this);
		Application.context.getContext().put("curPath",this.path);

		add(new BreadCrumbUI(path){{
			setBounds(80,25,800,25);
		}});
        
		//add button of all the ticket he or she have
		int NUM = ticketView.getTicketNumber();//Number of tickets
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
			FlightInfoView flightInfo = getData(i);
        	button[i] = new FlightInfoButtonUI(flightInfo.getDepartPlace(),flightInfo.getArrivePlace(),
        			flightInfo.getBookingID(),flightInfo.getDate(),flightInfo.getAirline(),flightInfo.getDepartureTime(),flightInfo.getArriveTime(),
        			flightInfo.getLastTime());
        	//TODO
        	if(i > 1) {
        		button[i].setStyle();
        	}
            button[i].buttonLayout();
            button[i].setBorder(BorderFactory.createCompoundBorder(button[i].getBorder(), BorderFactory.createEmptyBorder(20, 20, 20, 20))); 
            buttonPane.add(button[i]);
        }
        add(rightPanel = addPanel(0));
        add(new JScrollPane(buttonPane) {{
        	setBackground(Color.white);
        	setBounds(35,170,420,250);
        	getVerticalScrollBar().setUI(new DemoScrollBarUI());
        }});
        for(int i = 0;i < NUM;i++) {
        	int number = i;
        	 button[i].addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                	chooseTicket = number;
                	rightPanel.setVisible(false);
                	add(rightPanel = addPanel(chooseTicket));
             		System.out.println("I click button "+chooseTicket);
                 }
             });
        }
	}
	
	public void setNextAction() {
		System.out.println("next");
		FlightInfoView flightInfo = getData(chooseTicket);
		Application.context.getContext().put("flightInfo",flightInfo);
		
		try {
			new ChooseSeatFrm();
			Application.context.getPageConfig().displayPage(path.resolve(Path.of("/Retrieve/Flight Information/Choose Seat")));
		} catch (UnboundPageException e1) {
			e1.printStackTrace();
			return;
		}
	}
	public JPanel addPanel(int num) {
  		FlightInfoView flightInfo = getData(num);
  		FlightInfoPanelUI flightInfoPanel = new FlightInfoPanelUI(flightInfo.getBookingID(), 
  				flightInfo.getDate(), flightInfo.getAirline(),
  				flightInfo.getDepartPlace(), flightInfo.getArrivePlace(),
          	    flightInfo.getFlightNo(), flightInfo.getDepartureAirport(), flightInfo.getArriveAirport(), 
          	    flightInfo.getDepartureTime(),flightInfo.getArriveTime(),
          	    flightInfo.getLastTime(), "flightSeat", "flightFood", 
          	    flightInfo.getTerminalNo(),flightInfo.getGateNo(),
          	    flightInfo.getUserName(),flightInfo.getUserID()) {{
          	   checkLayout("Nomal","6A","sea food");
          	   setBounds(500, 80, 415, 355);
          }};
          return flightInfoPanel;
	}
	public FlightInfoView getData(int num) {
		Ticket ticket = ticketView.getTicket(num);
  		Flight flight = flightView.getFlight(ticket.getFlight());
  		Interval interval =  intervalView.getInterval(ticket.getFlight());
  		Plane plane = planeView.getPlane(flight.getId());
  		Airline airline = airlineView.getAirline(plane.getAirline().toString());
  		FlightInfoView flightInfo = new FlightInfoView(ticket,flight,plane,interval,airline);
  		return flightInfo;
	}
	public static void main(String[] args) {
		Application.run();
		FlightInfoFrm f = new FlightInfoFrm();
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	    f.setSize(965,550);
		f.setVisible(true);
	}
}