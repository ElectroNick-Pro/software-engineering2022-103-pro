package com.group2022103.flightkiosk.view;

import java.util.ArrayList;
import java.util.List;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.controller.ConfirmPayController;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.vo.ConfirmPayBack;
import com.group2022103.flightkiosk.vo.SeatBack;

@SuppressWarnings("unchecked")
public class ConfirmPayView {
	private ArrayList<OriginFood> allFoodChoice = new ArrayList<>();
	private List<FoodPurchase> allFoodPurchases = new ArrayList<>();
	private boolean haveExtraFood;
	private boolean haveOriginFood;
	
	public ConfirmPayView() {

	}
	public ConfirmPayView(ConfirmPayBack confirmPayBack) {
		new ConfirmPayController().get(confirmPayBack);
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
		
		return chosenSeat;
	}
	
	public Seat getSeatInData() {
		Seat chosenSeat = getSeat();
		SeatView seatView = new SeatView(new SeatBack() {{
			setIntervalId(-1);
			setTicketId(-1);
			setSeatId(chosenSeat.getId());
		}});
		Seat seatToSave = seatView.getSeatFront().get(0);
		seatToSave.setTicket(chosenSeat.getTicket());
		
		return seatToSave;
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
		FlightInfoView flightInfo = (FlightInfoView)Application.context.getContext().get("flightInfo");
		if(isGetOriginFood()) {
			OriginFood originFood = getOriginFood();
			//origin food
			FoodPurchase foodPurchase = new FoodPurchase();
			foodPurchase.setFood(originFood.getFoodID());
			foodPurchase.setTicket(flightInfo.getTicketID());
			foodPurchase.setCount(1);
			
			if(foodPurchase != null) {
				System.out.println("Origin Food ID: "+originFood.getFoodID());
				allFoodPurchases.add(k,foodPurchase);
				k ++;
			}
			
		}
		//extra food
		if(isGetExtraFood()) {
			ArrayList<OriginFood> extraFood = (ArrayList<OriginFood>) Application.context.getContext().get("ExtraFood");
			for(int i = 0; i < extraFood.size(); i ++) {
				FoodPurchase foodPurchase = new FoodPurchase();
				foodPurchase.setFood(extraFood.get(i).getFoodID());
				foodPurchase.setTicket(flightInfo.getTicketID());
				foodPurchase.setCount(extraFood.get(i).getCount());
				if(foodPurchase != null) {
					System.out.println("Extra Food ID: "+extraFood.get(i).getFoodID());
					allFoodPurchases.add(k, foodPurchase);
					k ++;
				}
			}
		}
		for(k = 0; k < allFoodPurchases.size(); k ++) {
			System.out.println("Food "+ k + "is: "+allFoodPurchases.get(k).getFood());
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
