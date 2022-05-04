package com.group2022103.flightkiosk.view;

import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.component.SeatButtonUI;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;

public class SeatView {
    private int seatId = -1;
    private int flightId;
    private SeatButtonUI seatChoiceBtn;
    private Seat[] allSeat;
    private SeatFront seatFront;
    private SeatBack seatBack;
    

    public SeatView(){

    }

    public SeatView(SeatBack seatBack){

    }

    public SeatView(SeatFront seatFront){

    }

    public SeatView(Seat seat){

    }
    
    public SeatView(int seatId) {
    	this.seatId = seatId;
    }

    public SeatView(SeatButtonUI seatBtn){
        this.seatChoiceBtn = seatBtn;
    }

    public ColorUIResource[] getButtonColor(){
		ColorUIResource[] color = new ColorUIResource[2];
		color[0] = new ColorUIResource(255,239,0);
		color[1] = new ColorUIResource(151,151,151);

		return color;
	}

	public SeatButtonUI chooseSeat(SeatButtonUI seatChoiceBtn){
		System.out.println(seatChoiceBtn.getSeatId());
        this.seatChoiceBtn = seatChoiceBtn;
        this.seatId = seatChoiceBtn.getSeatId();

        return this.seatChoiceBtn;
	}
	
	public int getSeatId() {
		return this.seatId;
	}
	
    public void getSeatStatus(){

    }

    public Seat[] getAllSeat(){

        return allSeat;
    }

}
