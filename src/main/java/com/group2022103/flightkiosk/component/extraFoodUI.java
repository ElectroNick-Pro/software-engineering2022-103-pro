package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;

public class extraFoodUI extends foodPanelUI{
	public RoundButtonUI foodButton;
	private SpinnerUI spinner;
	private String image;
	private String name;
	private double price;
	private int foodID;
	public extraFoodUI(int foodID,String image,String name,double price) {
		super(image,name);
		
		this.foodID = foodID;
		this.image = image;
		this.name = name;
		this.price = price;
		
		add(new JLabel("$"+price,SwingConstants.CENTER) {{
			setBounds(0,100,100,50);
			setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
			setForeground(new Color(226,37,37));
		}});
		
		add(spinner = new SpinnerUI() {{
			setBounds(100,115,90,20);
		}});
		
		add(foodButton = new RoundButtonUI(Color.WHITE,Color.WHITE) {{
			setBorderColor(Color.GRAY);
			setBounds(0,40,199,110);
		}});
	}
	
	public int getFoodID() {
		return foodID;
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
	
	public int getValue() {
		return spinner.getValue();
	}

	public void setValue(int value){
		spinner.setValue(value);
	}
}
