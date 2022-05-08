package com.group2022103.flightkiosk.view;

import java.util.ArrayList;

import com.group2022103.flightkiosk.component.extraFoodUI;
import com.group2022103.flightkiosk.component.originFoodUI;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.vo.*;

public class FoodView {
    private FoodFront originFoodFront;
    private FoodFront extraFoodFront;
    private originFoodUI[] originFood;	
    private extraFoodUI[] extraFood;
    
    public FoodView(FoodBack foodBack){
        originFoodFront = new FoodFront();
        ArrayList<Food> originFood = new ArrayList<Food>();
        originFood.add(new Food(){{setId(1); setImage("src/main/resources/image/Standard1.png"); setName("Standard"); setPrice(0.0);}});
        originFood.add(new Food(){{setId(2); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(3); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(4); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(5); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(6); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(7); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(8); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFood.add(new Food(){{setId(9); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        originFoodFront.setFoodContent(originFood);

        extraFoodFront = new FoodFront();
        ArrayList<Food> extraFood = new ArrayList<Food>();
        extraFood.add(new Food(){{setId(1); setImage("src/main/resources/image/Standard1.png"); setName("Standard"); setPrice(0.0);}});
        extraFood.add(new Food(){{setId(2); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(3); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(4); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(5); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(6); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(7); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(8); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFood.add(new Food(){{setId(9); setImage("src/main/resources/image/Hamburger3.png"); setName("Hamburger"); setPrice(4.5);}});
        extraFoodFront.setFoodContent(extraFood);

        // setOriginFoodFront(new FoodController().getOriginFood(FoodBack));
        // setExtraFoodFront(new FoodController().getExtraFood(FoodBack));
    }

    public void setOriginFoodFront(FoodFront originFoodFront){
        this.originFoodFront = originFoodFront;
    }

    public void setExtraFoodFront(FoodFront extraFoodFront){
        this.extraFoodFront = extraFoodFront;
    }

    public ArrayList<Food> getOriginFood(){
        return originFoodFront.getFoodContent();
    }

    public ArrayList<Food> getExtraFood(){
        return extraFoodFront.getFoodContent();
    }

    public originFoodUI[] getOriginFoodUI(){
        ArrayList<Food> food = originFoodFront.getFoodContent();
        originFood = new originFoodUI[food.size()];
        for(int i=0;i<food.size();i++){
			originFood[i] = new originFoodUI(food.get(i).getId(), food.get(i).getImage(), food.get(i).getName(), food.get(i).getPrice());
		}
        return originFood;
    }

    public extraFoodUI[] getExtraFoodUI(){
        ArrayList<Food> food = extraFoodFront.getFoodContent();
        extraFood = new extraFoodUI[food.size()];
        for(int i=0;i<food.size();i++){
			extraFood[i] = new extraFoodUI(food.get(i).getId(), food.get(i).getImage(), food.get(i).getName(), food.get(i).getPrice());
		}
        return extraFood;
    }
}
