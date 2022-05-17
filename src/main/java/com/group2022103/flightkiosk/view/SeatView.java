package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.SeatButtonUI;
import com.group2022103.flightkiosk.controller.PlaneController;
import com.group2022103.flightkiosk.controller.SeatController;
import com.group2022103.flightkiosk.mapper.SeatMapper;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.vo.PlaneBack;
import com.group2022103.flightkiosk.vo.PlaneFront;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;

public class SeatView {
    private int seatId = -1;
    private int ticketId = -1;
    private SeatButtonUI seatChoiceBtn;
    private List<Seat> seats;
    private SeatFront seatFront;
    private SeatBack seatBack;
    private String originSeatClass;
    private FlightInfoView flightInfo;
    private boolean isChosen = false;
    private Plane plane;
    
    public SeatView(SeatBack seatBack){
    	//get this user's ticketId
    	this.seatFront = new SeatController().get(seatBack);
    	this.originSeatClass = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getSeatClass();
    	this.ticketId = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getTicketID();
    	this.seats = getSeatFront();
    	
    	int planeId = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getPlaneID();
    	List<String> planeIDList = new ArrayList<String>();
    	planeIDList.add(planeId+"");
    	PlaneBack planeBack = new PlaneBack();
    	planeBack.setPlaneID(planeIDList);
    	PlaneView planeView = new PlaneView(planeBack);
    	PlaneFront planeFront = new PlaneController().get(planeBack);
    	Map<Integer,Plane> planes = planeFront.getPlanes();
    	for(Plane value : planes.values()) {
    		this.plane = value;
    	}
    }
    
    public List<Seat> getSeatFront() {
    	return seatFront.getSeats();
    }
    
    public int getRowLength() {
    	return this.plane.getRowLength();
    }
    
    public int getColumnLength() {
    	return this.plane.getColumnLength();
    }
    
    public ColorUIResource[] getButtonColor(){
    	/*
    	 * 0: no others choose it
    	 * 1: others choose it
    	 */
    	int status = getSeatStatus();
    	String seatClass = seats.get(0).getSeatClass();
    	String seatType = seats.get(0).getType();
    	ColorUIResource[] color = new ColorUIResource[2];
    	switch (status) {
    		case 0:
    			if(seatClass.equals("First")) {
    				if(seatType.equals("Extra")) {
    					color[0] = new ColorUIResource(255,215,185);
    				}else {
    					color[0] = new ColorUIResource(249,237,166);
    				}
    			}else {
    				if(originSeatClass.equals("First Class")) {
    					color[0] = new ColorUIResource(205,205,205);
    				}else {
    					if(seatType.equals("Extra")) {
        					color[0] = new ColorUIResource(253,231,201);
        				}else {
        					color[0] = new ColorUIResource(209,245,252);
        				}
    				}
    			}
    			break;
    		case 1:
    			color[0] = new ColorUIResource(205,205,205);
    			break;
    	}
		
		color[1] = new ColorUIResource(205,205,205);

		return color;
	}

	public void chooseSeat(SeatButtonUI seatChoiceBtn){
        this.seatChoiceBtn = seatChoiceBtn;
        seatId = seatChoiceBtn.getSeatId();
        Seat seat = seats.get(0);
        int intervalId = seat.getInterval();
        int ticketId = this.ticketId;
        int columnNo = seat.getColumnNo();
        int rowNo = seat.getRowNo();
        String seatNo = seat.getSeatNo();
        String seatClass = seat.getSeatClass();
        boolean upgrade = false;
        Double price = seat.getPrice();
        String type = seat.getType();
        if(seatClass.equals("First")) {
        	if(originSeatClass.equals("Normal")) {
        		upgrade = true;
        	}else {
        		SeatFront seatFront2 = new SeatController().get(new SeatBack() {{
        			setIntervalId(seat.getInterval());
        			setTicketId(-1);
        			setSeatId(-1);
        		}});
        		price = price - seatFront2.getSeats().get(0).getPrice();
        	}
        }
        
        
        SeatChoice seatChoice = new SeatChoice(intervalId, ticketId, seatId, columnNo, rowNo, seatNo, seatClass, price, type, upgrade);
        Application.context.getContext().put("SeatChoice", seatChoice);
	}
	
	public boolean canChooseSeat() {
		boolean canChoose = true;
		Seat seat = seats.get(0);
		for(int i = 0; i < seats.size(); i ++) {
			seat = seats.get(i);
			if(seat.getTicket() != null) {
				if(seat.getTicket() == ticketId) {
					canChoose = false;
			        int intervalId = seat.getInterval();
			        int ticketId = this.ticketId;
			        int columnNo = seat.getColumnNo();
			        int rowNo = seat.getRowNo();
			        String seatNo = seat.getSeatNo();
			        String seatClass = seat.getSeatClass();
			        boolean upgrade = false;
			        Double price = seat.getPrice();
			        String type = seat.getType();
			        if(seatClass.equals("First")) {
			        	if(originSeatClass.equals("Normal")) {
			        		upgrade = true;
			        	}else {
			        		SeatFront seatFront2 = new SeatController().get(new SeatBack() {{
			        			setIntervalId(intervalId);
			        			setTicketId(-1);
			        			setSeatId(-1);
			        		}});
			        		price = 0.0;
			        	}
			        }
			        SeatChoice seatChoice = new SeatChoice(intervalId, ticketId, seatId, columnNo, rowNo, seatNo, seatClass, price, type, upgrade);
			        Application.context.getContext().put("SeatChoice", seatChoice);
					break;
				}
			}
		}
		
		return canChoose;
	}
	
    public int getSeatStatus(){
    	/*
    	 * 0: no one choose it
    	 * 1: others choose it
    	 * 2: this user choose it
    	 */
    	int status = -1;
    	
    	Seat seat = seats.get(0);
    	if(seat.getTicket() != null) {
    		if(seat.getTicket() == this.ticketId) {
    			isChosen = true;
    		}else {
    			status = 1;
    		}
    	}else {
    		status = 0;
    	}
    	return status;
    }
    
    public boolean isChosen() {
    	//true: is chosen by this user
    	Seat seat = seats.get(0);
    	if(seat.getTicket() != null) {
    		if(seat.getTicket() == this.ticketId) {
    			this.isChosen = true;
    		}else {
    			this.isChosen = false;
    		}
    	}else {
    		this.isChosen = false;
    	}
    	return this.isChosen;
    }
    
    public List<Seat> getAllSeats(){
    	return this.seats;
    }
}
