package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class extraFoodUI extends foodPanelUI{
	public RoundButtonUI foodButton;
	private int foodID;
	private int count;
	private SpinnerUI spinner;
	public extraFoodUI(String image,String name,double price,int foodID) {
		super(image,name);
		
		this.foodID = foodID;
		
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
	
	public int getValue() {
		return spinner.getValue();
	}
}
