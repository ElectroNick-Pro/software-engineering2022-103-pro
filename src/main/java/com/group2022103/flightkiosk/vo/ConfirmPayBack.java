package com.group2022103.flightkiosk.vo;

import java.util.List;
import java.util.Map;

import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;

public class ConfirmPayBack {
	//all variables are used to be written into our data
	private List<FoodPurchase> foodChoice;
	private Seat seat;
	
	public List<FoodPurchase> getFoodChoice() {
		return foodChoice;
	}
	public void setFoodChoice(List<FoodPurchase> foodChoice) {
		this.foodChoice = foodChoice;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
