package com.group2022103.flightkiosk.view;

import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.component.SeatButtonUI;
import com.group2022103.flightkiosk.model.Seat;

public class SeatService {
    private int seatId = -1;
    private SeatButtonUI seatChoiceBtn;
    private Seat[] allSeat;
    public SeatService(){

    }

    public SeatService(Seat seat){

    }

    public SeatService(SeatButtonUI seatBtn){
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

    public void getSeatStatus(){

    }

    public Seat[] getAllSeat(){

        return allSeat;
    }

}
