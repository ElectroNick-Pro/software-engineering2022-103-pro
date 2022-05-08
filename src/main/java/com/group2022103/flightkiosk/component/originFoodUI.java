package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;

public class originFoodUI extends foodPanelUI{
	public RoundButtonUI foodButton;
	private String image,name;
	private double price;
	private int foodID;
	private JLabel ok;
	public originFoodUI(int foodID,String image,String name,double price) {
		super(image,name);
		
		this.foodID = foodID;
		this.image = image;
		this.name = name;
		this.price = price;
		
		if(price == 0.0) {
			add(new JLabel("FREE",SwingConstants.CENTER) {{
				setBounds(0,100,200,50);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(0,131,255));
			}});
		}else {
			add(new JLabel("$"+price,SwingConstants.CENTER) {{
				setBounds(0,100,200,50);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(226,37,37));
			}});	
		}
		
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
