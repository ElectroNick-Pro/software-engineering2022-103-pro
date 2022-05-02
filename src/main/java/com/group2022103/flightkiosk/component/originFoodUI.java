package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class originFoodUI extends foodPanelUI{
	public RoundButtonUI foodButton;
	private String image,name;
	private double price;
	private int foodID;
	private JLabel ok;
	public originFoodUI(String image,String name,double price,int foodID) {
		super(image,name);
		
		this.foodID = foodID;
		this.image = image;
		this.name = name;
		this.price = price;
		
		add(new JLabel("$"+price,SwingConstants.CENTER) {{
			setBounds(0,100,200,50);
			setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
			setForeground(new Color(226,37,37));
		}});	
		
		add(ok = new JLabel(new ImageIcon("src/main/resources/image/success1.png")) {{
			setBounds(0,80,50,50);
			setVisible(false);
		}});
		
		add(foodButton = new RoundButtonUI(Color.WHITE,new Color(226,226,226)) {{
			setBorderColor(Color.GRAY);
			setBounds(0,40,199,110);
		}});
	}
	
	public String getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getFoodID() {
		return foodID;
	}
	
	public void setChoice() {
		ok.setVisible(true);
	}
	
	public void cancelChoice() {
		ok.setVisible(false);
	}
}
