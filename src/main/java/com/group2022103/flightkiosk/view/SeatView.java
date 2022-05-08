package com.group2022103.flightkiosk.view;

import java.util.List;

import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.SeatButtonUI;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;

public class SeatView {
    private int seatId = -1;
    private int ticketId = -1;
    private int flightId;
    private SeatButtonUI seatChoiceBtn;
    private List<Seat> allSeat;
    private SeatFront seatFront = new SeatFront();
    private SeatBack seatBack = new SeatBack();
    

    public SeatView(SeatBack seatBack){
    	//get this user's ticketId
    }
    

    public ColorUIResource[] getButtonColor(int seatId){
//    	int status = getSeatStatus(seatId);
		ColorUIResource[] color = new ColorUIResource[2];
		color[0] = new ColorUIResource(255,239,0);
		color[1] = new ColorUIResource(151,151,151);

		return color;
	}

	public void chooseSeat(SeatButtonUI seatChoiceBtn){
		System.out.println(seatChoiceBtn.getSeatId());
        this.seatChoiceBtn = seatChoiceBtn;
        this.seatId = seatChoiceBtn.getSeatId();
        
        //get information of ticket and intervalId from GlobalData
        int intervalId = 1;
        int ticketId = 3;
        int columnNo = 4;
        int rowNo = 10;
        String seatNo = seatId+"A";
        String seatClass = "First";
        Double price = 50.0; //decide according to if "upgrade"
        String type = "Window";
        boolean upgrade = false;
        SeatChoice seatChoice = new SeatChoice(intervalId, ticketId, seatId, columnNo, rowNo, seatNo, seatClass, price, type, upgrade);
        Application.context.getContext().put("SeatChoice", seatChoice);
	}
	
	
    public int getSeatStatus(int seatId){
    	/*
    	 * 0: no one choose it
    	 * 1: others choose it
    	 * 2: this user choose it
    	 */
    	int status = -1;
    	this.seatId = seatId;
    	
    	seatBack.setSeatId(seatId);
    	Seat seat = seatFront.getSeats().get(0);
    	if(seat.getTicket() != null) {
    		if(seat.getTicket() == this.ticketId) {
    			status = 2;
    		}else {
    			status = 1;
    		}
    	}else {
    		status = 0;
    	}
    	
    	return status;
    }

    public List<Seat> getAllSeat(){
        return allSeat;
    }

}
