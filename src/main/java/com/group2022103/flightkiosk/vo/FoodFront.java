package com.group2022103.flightkiosk.vo;

import java.util.ArrayList;

import com.group2022103.flightkiosk.model.Food;

public class FoodFront {
    private ArrayList<Food> originFood;
    private ArrayList<Food> extraFood;

    public void setOriginFood(ArrayList<Food> originFood){
        this.originFood = originFood;
    }

    public ArrayList<Food> getOriginFood(){
        return originFood;
    }

    public void setExtraFood(ArrayList<Food> extraFood){
        this.extraFood = extraFood;
    }

    public ArrayList<Food> getExtraFood(){
        return extraFood;
    }
}
