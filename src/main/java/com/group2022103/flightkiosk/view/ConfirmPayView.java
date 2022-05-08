package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.List;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.vo.ConfirmPayBack;
import com.group2022103.flightkiosk.vo.ConfirmPayFront;
import com.group2022103.flightkiosk.vo.SeatBack;
import com.group2022103.flightkiosk.vo.SeatFront;

public class ConfirmPayView {
	private Seat seat;
	private OriginFood originFood;
	private ArrayList<OriginFood> allFoodChoice;
	private ArrayList<FoodPurchase> allFoodPurchases;
	private boolean getExtraFood;
	private ConfirmPayBack confirmPayBack;
	private ConfirmPayFront confirmPayFront;
	
	public ConfirmPayView() {}
	
	public ConfirmPayView(ConfirmPayBack confirmPayBack){}

    public ConfirmPayView(ConfirmPayFront confirmPayFront){}

	public Seat getSeat() {
		SeatChoice seatChoice = (SeatChoice)Application.context.getContext().get("SeatChoice");
		Seat chosenSeat = new Seat();
		chosenSeat.setId(seatChoice.getSeatId());
		chosenSeat.setInterval(seatChoice.getIntervalId());
		chosenSeat.setColumnNo(seatChoice.getColumnNo());
		chosenSeat.setRowNo(seatChoice.getRowNo());
		chosenSeat.setSeatNo(seatChoice.getSeatNo());
		chosenSeat.setSeatClass(seatChoice.getSeatClass());
		chosenSeat.setPrice(seatChoice.getPrice());
		chosenSeat.setTicket(seatChoice.getTicketId());
		chosenSeat.setType(seatChoice.getType());
		
		this.seat = chosenSeat;
		
		return chosenSeat;
	}
	
	public OriginFood getOriginFood() {
		OriginFood originFood = (OriginFood)Application.context.getContext().get("OriginFood");
		return originFood;
	}
	
	public boolean isGetExtraFood() {
		ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
		if(extraFood != null) {
			getExtraFood = true;
		}else {
			getExtraFood = false;
		}
		return getExtraFood;
	}

	public ArrayList<OriginFood> getAllFoodChoice() {
		OriginFood originFood = getOriginFood();
		allFoodChoice.add(0, originFood);
		if(isGetExtraFood()) {
			ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
			for(int i = 0; i < extraFood.size(); i ++) {
				this.allFoodChoice.add(i+1, extraFood.get(i));
			}
		}
		return allFoodChoice;
	}
	
	public ArrayList<FoodPurchase> getAllFoodPurchases() {
		OriginFood originFood = (OriginFood)Application.context.getContext().get("OriginFood");
		FoodPurchase foodChoice = new FoodPurchase();
		
		//origin food
		foodChoice.setId(originFood.getFoodID());
		foodChoice.setPrice(originFood.getPrice());
		foodChoice.setName(originFood.getName());
		foodChoice.setType("Origin");
		foodChoice.setFlight(1);
		foodChoice.setImage(originFood.getImage());
		
		this.allFoodPurchases.add(0, foodChoice);
		
		//extra food
		if(isGetExtraFood()) {
			ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
			for(int i = 0; i < extraFood.size(); i ++) {
				foodChoice.setId(extraFood.get(i).getFoodID());
				foodChoice.setPrice(extraFood.get(i).getPrice());
				foodChoice.setName(extraFood.get(i).getName());
				foodChoice.setType("Extra");
				foodChoice.setFlight(1);
				foodChoice.setImage(extraFood.get(i).getImage());
				this.allFoodPurchases.add(i+1, foodChoice);
			}
		}
		
		return allFoodPurchases;
	}
	
	public void confirmAllChoice() {
		confirmPayBack.setSeat(getSeat());
		confirmPayBack.setFoodChoice(getAllFoodPurchases());
	}
	
}
