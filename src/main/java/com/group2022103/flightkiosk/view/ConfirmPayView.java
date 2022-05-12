package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.List;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.SeatController;
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
	private ArrayList<OriginFood> allFoodChoice = new ArrayList<>();
	private List<FoodPurchase> allFoodPurchases = new ArrayList<>();
	private boolean haveExtraFood;
	private boolean haveOriginFood;
	private ConfirmPayBack confirmPayBack;
	private ConfirmPayFront confirmPayFront;
	
	public ConfirmPayView() {
		
	}
	public ConfirmPayView(ConfirmPayBack confirmPayBack) {
		
	}

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
	public boolean isGetOriginFood() {
		OriginFood originFood = (OriginFood)Application.context.getContext().get("OriginFood");
		if(originFood != null) {
			haveOriginFood = true;
		}else {
			haveOriginFood = false;
		}
		return haveOriginFood;
	}
	
	public boolean isGetExtraFood() {
		ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
		if(extraFood != null) {
			haveExtraFood = true;
		}else {
			haveExtraFood = false;
		}
		return haveExtraFood;
	}

	public ArrayList<OriginFood> getAllFoodChoice() {
		
		int k = 0;
		if(isGetOriginFood()) {
			allFoodChoice.add(k,getOriginFood());
			k++;
		}
		if(isGetExtraFood()) {
			ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
			System.out.println("extra: "+ extraFood.size());
			for(int i = 0; i < extraFood.size(); i ++) {
				if(extraFood.get(i) != null) {
					allFoodChoice.add(k,extraFood.get(i));
					k ++;
				}
			}
		}
		return allFoodChoice;
	}
	
	public List<FoodPurchase> getAllFoodPurchases() {
		int k = 0;
		FoodPurchase foodPurchase = new FoodPurchase();
		if(isGetOriginFood()) {
			OriginFood originFood = getOriginFood();
			//origin food
			foodPurchase.setId(originFood.getFoodID());
			foodPurchase.setPrice(originFood.getPrice());
			foodPurchase.setName(originFood.getName());
			foodPurchase.setType("Origin");
			foodPurchase.setFlight(1);
			foodPurchase.setImage(originFood.getImage());
			if(foodPurchase != null) {
				allFoodPurchases.add(k,foodPurchase);
				k ++;
			}
			
		}
		//extra food
		if(isGetExtraFood()) {
			ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
			for(int i = 0; i < extraFood.size(); i ++) {
				foodPurchase.setId(extraFood.get(i).getFoodID());
				foodPurchase.setPrice(extraFood.get(i).getPrice());
				foodPurchase.setName(extraFood.get(i).getName());
				foodPurchase.setType("Extra");
				foodPurchase.setFlight(1);
				foodPurchase.setImage(extraFood.get(i).getImage());
				if(foodPurchase != null) {
					allFoodPurchases.add(k, foodPurchase);
					k ++;
				}
			}
		}
		
		return allFoodPurchases;
	}
	
	public Double getFoodPrice() {
		double foodPrice = 0.0;
		for(int i = 0; i < allFoodChoice.size(); i ++) {
			foodPrice = foodPrice + allFoodChoice.get(i).getPrice() * allFoodChoice.get(i).getCount();
		}
		return foodPrice;
	}
	
	public Double getTotalPrice() {
		Seat seat = getSeat();
		double totalPrice = getFoodPrice() + seat.getPrice();
		return totalPrice;
	}
	
}
