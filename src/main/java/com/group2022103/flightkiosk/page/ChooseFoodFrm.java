package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class ChooseFoodFrm extends PageFrm{
	private Path path = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food");
	private ArrayList<Food> food;
	private originFoodUI[] foodContent;
	private originFoodUI foodChoice;	
	private int foodNumber;
	private int rows = 2;
	private int flightId = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getFlightID();
	public ChooseFoodFrm() {
		super();
		setTitleName("Choose Food");
		setHintName("You can choose a type of food you perfer:");
		setBackButton();
		setNextButton();
		addExitButton();
		addHelpButton();
		Application.context.getPageConfig().bindPage(this.path, this);
		Application.context.getContext().put("curPath",this.path);

		add(new BreadCrumbUI(path){{
			setBounds(80,25,800,25);
		}});

		new FoodView(new FoodBack(){{
            setFlightId(flightId);
        }}){{
			food = getOriginFood();
			foodNumber = food.size();
			foodContent = new originFoodUI[foodNumber];
			for(int i=0;i<foodNumber;i++){
				foodContent[i] = new originFoodUI(food.get(i).getId(), food.get(i).getImage(), food.get(i).getName(), food.get(i).getPrice());
			}
			rows = foodNumber%4==0?foodNumber/4:foodNumber/4+1;
		}};
		
		add(new JScrollPane(new JPanel() {{
			setLayout(new GridLayout(0,4,20,0));
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(0, 150*rows));
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
		
		OriginFood oldChoice = (OriginFood)Application.context.getContext().get("OriginFood");
		if(oldChoice != null){
			int foodID = oldChoice.getFoodID();
			for(int i=0;i<foodNumber;i++){
				originFoodUI newChoice = foodContent[i];
				if(newChoice.getFoodID() == foodID){
					if(foodChoice != null) {
						foodChoice.cancelChoice();
					}
					newChoice.setChoice();
					foodChoice = newChoice;
				}
			}
		}
	}
	
	public void setNextAction() {
		System.out.println("next");
		if(foodChoice == null){
			JOptionPane.showMessageDialog(null, "Please choose a type of food you perfer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
		}
		Application.context.getContext().put("OriginFood",new OriginFood(foodChoice.getFoodID(),foodChoice.getImage(),foodChoice.getName(),foodChoice.getPrice(),1));
        try {
			new ExtraFoodFrm();
			Application.context.getPageConfig().displayPage(path.resolve(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food")));
		} catch (UnboundPageException e1) {
			e1.printStackTrace();
			return;
		}
	}
}