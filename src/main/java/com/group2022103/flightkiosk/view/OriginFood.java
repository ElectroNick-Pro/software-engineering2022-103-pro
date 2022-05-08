package com.group2022103.flightkiosk.view;

public class OriginFood {
    private int foodID;
    private String image;
    private String name;
    private double price;
    private int count;

    public OriginFood(int foodID, String image, String name, double price, int count){
        this.foodID = foodID;
        this.image = image;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getFoodID(){
        return this.foodID;
    }

    public String getImage(){
        return this.image;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getCount(){
        return this.count;
    }
}
