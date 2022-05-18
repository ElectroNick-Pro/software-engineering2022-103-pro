package com.group2022103.flightkiosk.viewTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.ConfirmPayView;
import com.group2022103.flightkiosk.view.FoodView;
import com.group2022103.flightkiosk.view.OriginFood;
import com.group2022103.flightkiosk.view.SeatChoice;
import com.group2022103.flightkiosk.view.SeatView;
import com.group2022103.flightkiosk.vo.FoodBack;
import com.group2022103.flightkiosk.vo.SeatBack;

public class ConfirmPayViewTest {
	@Test
	public void test() {
		Application.run();
		ConfirmPayView confirmPayView = new ConfirmPayView();
		SeatChoice seatChoice = new SeatChoice(1, 1, 1, 1, 1, "1A", "First", 100.0, "Normal", true);
        Application.context.getContext().put("SeatChoice", seatChoice);
        Seat seat = new Seat();
        seat.setId(1);
        seat.setInterval(1);
        seat.setColumnNo(1);
        seat.setRowNo(1);
        seat.setPrice(100.0);
        seat.setSeatClass("First");
        seat.setSeatNo("1A");
        seat.setTicket(1);
        seat.setType("Normal");
        assertEquals(confirmPayView.getSeat().getId(), seat.getId());
        assertEquals(confirmPayView.getSeatInData().getId(), seat.getId());
        
        Application.context.getContext().put("OriginFood",new OriginFood(1,"","Food",10.0,1));
        assertEquals(confirmPayView.getOriginFood().getFoodID(), 1);
        assertEquals(confirmPayView.isGetOriginFood(), true);
        
        ArrayList<OriginFood> ExtraFood = new ArrayList<OriginFood>();
        for(int i=0;i<3;i++){
			ExtraFood.add(new OriginFood(i+1,"", "Food "+i+1, 5.0, i+1));
		}
		Application.context.getContext().put("ExtraFood",ExtraFood);
		assertEquals(confirmPayView.isGetExtraFood(), true);
		
		ArrayList<OriginFood> allFood = new ArrayList<OriginFood>();
		allFood.add(new OriginFood(1,"","Food",10.0,1));
		allFood.add(ExtraFood.get(0));
		allFood.add(ExtraFood.get(1));
		allFood.add(ExtraFood.get(2));
		assertEquals(confirmPayView.getAllFoodChoice().size(), allFood.size());
		
		Double foodPrice = 0.0;
		foodPrice = foodPrice + 10.0;
		for(int i = 0; i < ExtraFood.size(); i ++) {
			foodPrice = foodPrice + ExtraFood.get(i).getPrice() * ExtraFood.get(i).getCount();
		}
		assertSame(confirmPayView.getAllFoodPurchases().get(1).getFood(), ExtraFood.get(0).getFoodID());
		assertEquals(confirmPayView.getFoodPrice(), foodPrice);
		Double totalPrice = foodPrice + seat.getPrice();
		assertEquals(confirmPayView.getTotalPrice(), totalPrice);
	}
}
