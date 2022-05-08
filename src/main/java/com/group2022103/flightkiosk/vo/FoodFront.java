package com.group2022103.flightkiosk.vo;

import java.util.ArrayList;

import com.group2022103.flightkiosk.model.Food;

public class FoodFront {
    private ArrayList<Food> foodContent;

    public void setFoodContent(ArrayList<Food> foodContent){
        this.foodContent = foodContent;
    }

    public ArrayList<Food> getFoodContent(){
        return foodContent;
    }
}
