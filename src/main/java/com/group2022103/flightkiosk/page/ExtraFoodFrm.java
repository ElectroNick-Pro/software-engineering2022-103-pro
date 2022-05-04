package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.component.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExtraFoodFrm extends PageFrm{
	private extraFoodUI[] foodContent;	
	private int foodNumber = 9;
	public ExtraFoodFrm() {
		super();
		setTitleName("Extra Food");
		setHintName("You can choose some extra food:");
		setBackButton();
		setNextButton();
		
		foodContent = new extraFoodUI[foodNumber];
		foodContent[0] = new extraFoodUI("src/main/resources/image/Standard1.png","Standard",5,1);
		foodContent[1] = new extraFoodUI("src/main/resources/image/Hamburger3.png","Hamburger",6,2);
		foodContent[2] = new extraFoodUI("src/main/resources/image/child6.png","Children",7,3);
		foodContent[3] = new extraFoodUI("src/main/resources/image/Standard1.png","Standard",5,4);
		foodContent[4] = new extraFoodUI("src/main/resources/image/Hamburger3.png","Hamburger",6,5);
		foodContent[5] = new extraFoodUI("src/main/resources/image/child6.png","Children",7,6);
		foodContent[6] = new extraFoodUI("src/main/resources/image/Standard1.png","Standard",5,7);
		foodContent[7] = new extraFoodUI("src/main/resources/image/Hamburger3.png","Hamburger",6,8);
		foodContent[8] = new extraFoodUI("src/main/resources/image/child6.png","Children",7,9);
		
		add(new JScrollPane(new JPanel() {{
			setLayout(new GridLayout(0,4,20,0));
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(0, 150*3));
            for(int i = 0; i < foodNumber; i ++) {
            	add(foodContent[i]);
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
		for(int i=0;i<foodNumber;i++) {
			if(foodContent[i].getValue() != 0) {
				if(foodContent[i].getValue() > 10){
					JOptionPane.showMessageDialog(null, "The upper limit of the food choice is 10.", "Error", JOptionPane.ERROR_MESSAGE);
					foodContent[i].setValue(10);
					return;
				}
				System.out.println("ID: "+foodContent[i].getFoodID()+" count: "+foodContent[i].getValue());
			}
		}
		
	}
}
