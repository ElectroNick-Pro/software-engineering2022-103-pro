package com.group2022103.flightkiosk.view;

import java.util.ArrayList;

import com.group2022103.flightkiosk.controller.FoodController;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.vo.*;

public class FoodView {
    private FoodFront originFoodFront;
    private FoodFront extraFoodFront;
    
    public FoodView(FoodBack foodBack){
        setOriginFoodFront(new FoodController().get(foodBack));
        setExtraFoodFront(new FoodController().get(foodBack));
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
}