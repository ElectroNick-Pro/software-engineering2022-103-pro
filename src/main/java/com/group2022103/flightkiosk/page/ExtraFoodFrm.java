package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.FoodBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExtraFoodFrm extends PageFrm{
	private extraFoodUI[] foodContent;	
	private int foodNumber;
	public ExtraFoodFrm() {
		super();
		setTitleName("Extra Food");
		setHintName("You can choose some extra food:");
		setBackButton();
		setNextButton();

		// OriginFood originFood = (OriginFood)Application.context.getContext().get("OriginFood");
		// int FoodID = originFood.getFoodID();
		// String image = originFood.getImage();
		// String name = originFood.getName();
		// double price = originFood.getPrice();
		// int count = originFood.getCount();
		// System.out.println(originFood.getFoodID() + " " + originFood.getImage() + "" + originFood.getName() + " " + originFood.getPrice() + " " + originFood.getCount());
		
		new FoodView(new FoodBack()){{
			foodContent = getExtraFoodUI();
			foodNumber = foodContent.length;
		}};
		
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
		ArrayList<OriginFood> ExtraFood = new ArrayList<OriginFood>();
		boolean isValid = true;
		for(int i=0;i<foodNumber;i++) {
			if(foodContent[i].getValue() != 0) {
				if(foodContent[i].getValue() > 10){
					isValid = false;
					foodContent[i].setValue(10);
				}
			}
		}
		if(isValid){
			for(int i=0;i<foodNumber;i++){
				if(foodContent[i].getValue() > 0){
					ExtraFood.add(new OriginFood(foodContent[i].getFoodID(),foodContent[i].getImage(), foodContent[i].getName(), foodContent[i].getPrice(), foodContent[i].getValue()));
				}
			}
			Application.context.getContext().put("ExtraFood",ExtraFood);
			this.dispose();
			new ConfirmPayFrm().setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "The upper limit of the food choice is 10.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void main(String args[]) {
		ExtraFoodFrm f = new ExtraFoodFrm();
		f.setVisible(true);
	}
}
