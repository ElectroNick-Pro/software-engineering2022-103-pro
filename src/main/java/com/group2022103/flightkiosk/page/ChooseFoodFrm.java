package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.component.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChooseFoodFrm extends PageFrm{
	private originFoodUI[] foodContent;	
	private int foodNumber = 9;
	private String image,name;
	private double price;
	private int foodID;
	private originFoodUI foodChoice;
	public ChooseFoodFrm() {
		super();
		setTitleName("Choose Food");
		setHintName("You can choose a type of food you perfer:");
		setBackButton();
		setNextButton();
		
		foodContent = new originFoodUI[foodNumber];
		foodContent[0] = new originFoodUI("src/main/resources/image/Standard1.png","Standard",5,1);
		foodContent[1] = new originFoodUI("src/main/resources/image/Hamburger3.png","Hamburger",6,2);
		foodContent[2] = new originFoodUI("src/main/resources/image/child6.png","Children",7,3);
		foodContent[3] = new originFoodUI("src/main/resources/image/Standard1.png","Standard",5,4);
		foodContent[4] = new originFoodUI("src/main/resources/image/Hamburger3.png","Hamburger",6,5);
		foodContent[5] = new originFoodUI("src/main/resources/image/child6.png","Children",7,6);
		foodContent[6] = new originFoodUI("src/main/resources/image/Standard1.png","Standard",5,7);
		foodContent[7] = new originFoodUI("src/main/resources/image/Hamburger3.png","Hamburger",6,8);
		foodContent[8] = new originFoodUI("src/main/resources/image/child6.png","Children",7,9);
		
		add(new JScrollPane(new JPanel() {{
			setLayout(new GridLayout(0,4,20,0));
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(0, 150*3));
            for(int i = 0; i < foodNumber; i ++) {
            	originFoodUI newChoice = foodContent[i];
            	add(newChoice);
            	newChoice.foodButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	if(foodChoice != null) {
                    		foodChoice.cancelChoice();
                    	}
                    	newChoice.setChoice();
                    	foodChoice = newChoice;
                    	foodID = newChoice.getFoodID();
                    	image = newChoice.getImage();
                    	name = newChoice.getName();
                    	price = newChoice.getPrice();
//                    	System.out.println(foodID+" "+image+" "+name+" "+price);
                    }
                });
            }
		}}) {{
			setBounds(40,150,870,305);
			getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
		}});
	}
	
	public void setBackAction() {
		System.out.println("back");
	}
	
	public void setNextAction() {
		System.out.println("next");
	}
}
