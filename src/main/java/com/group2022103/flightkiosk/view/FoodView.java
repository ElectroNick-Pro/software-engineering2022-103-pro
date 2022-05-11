package com.group2022103.flightkiosk.view;

import java.util.ArrayList;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.extraFoodUI;
import com.group2022103.flightkiosk.component.originFoodUI;
import com.group2022103.flightkiosk.controller.FoodController;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.vo.*;

public class FoodView {
    private FoodFront originFoodFront;
    private FoodFront extraFoodFront;
    private originFoodUI[] originFood;	
    private extraFoodUI[] extraFood;
    private int originFoodNumber;
    private int extraFoodNumber;
    
    public FoodView(FoodBack foodBack){
        // flightId should be got from the global data
        int flightId = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getFlightID();
        setOriginFoodFront(new FoodController().get(new FoodBack(){{
            setFlightId(flightId);
        }}));
        originFoodNumber = originFoodFront.getOriginFood().size();
        setExtraFoodFront(new FoodController().get(new FoodBack(){{
            setFlightId(flightId);
        }}));
        extraFoodNumber = extraFoodFront.getExtraFood().size();
    }

    public void setOriginFoodFront(FoodFront originFoodFront){
        this.originFoodFront = originFoodFront;
    }

    public void setExtraFoodFront(FoodFront extraFoodFront){
        this.extraFoodFront = extraFoodFront;
    }

    public ArrayList<Food> getOriginFood(){
        return originFoodFront.getOriginFood();
    }

    public ArrayList<Food> getExtraFood(){
        return extraFoodFront.getExtraFood();
    }

    public int getOriginFoodNumber(){
        return originFoodNumber%4==0?originFoodNumber/4:originFoodNumber/4+1;
    }

    public int getExtraFoodNumber(){
        return extraFoodNumber%4==0?extraFoodNumber/4:extraFoodNumber/4+1;
    }

    public originFoodUI[] getOriginFoodUI(){
        ArrayList<Food> food = originFoodFront.getOriginFood();
        originFood = new originFoodUI[food.size()];
        for(int i=0;i<food.size();i++){
			originFood[i] = new originFoodUI(food.get(i).getId(), food.get(i).getImage(), food.get(i).getName(), food.get(i).getPrice());
		}
        return originFood;
    }

    public extraFoodUI[] getExtraFoodUI(){
        ArrayList<Food> food = extraFoodFront.getExtraFood();
        extraFood = new extraFoodUI[food.size()];
        for(int i=0;i<food.size();i++){
			extraFood[i] = new extraFoodUI(food.get(i).getId(), food.get(i).getImage(), food.get(i).getName(), food.get(i).getPrice());
		}
        return extraFood;
    }
}
