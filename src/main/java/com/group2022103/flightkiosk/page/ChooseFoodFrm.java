package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChooseFoodFrm extends PageFrm{
	private originFoodUI[] foodContent;	
	private int foodNumber;
	private originFoodUI foodChoice;
	public ChooseFoodFrm() {
		super();
		setTitleName("Choose Food");
		setHintName("You can choose a type of food you perfer:");
		setBackButton();
		setNextButton();

		new FoodView(new FoodBack()){{
			foodContent = getOriginFoodUI();
			foodNumber = foodContent.length;
		}};
		
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
		Application.context.getContext().put("OriginFood",new OriginFood(foodChoice.getFoodID(),foodChoice.getImage(),foodChoice.getName(),foodChoice.getPrice(),1));
		this.dispose();
		new ExtraFoodFrm().setVisible(true);
	}

	public static void main(String args[]) {
		Application.run();
		ChooseFoodFrm f = new ChooseFoodFrm();
		f.setVisible(true);
	}
}
