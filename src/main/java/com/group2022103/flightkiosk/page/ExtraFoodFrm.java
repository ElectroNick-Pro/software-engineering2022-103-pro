package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.Food;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.FoodBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class ExtraFoodFrm extends PageFrm{
	private Path path = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food");
	private ArrayList<Food> food;
	private extraFoodUI[] foodContent;	
	private int foodNumber;
	private int rows = 2;
	private int flightId = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getFlightID();
	public ExtraFoodFrm() {
		super();
		setTitleName("Extra Food");
		setHintName("You can choose some extra food:");
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
			food = getExtraFood();
			foodNumber = food.size();
			foodContent = new extraFoodUI[foodNumber];
			for(int i=0;i<foodNumber;i++){
				foodContent[i] = new extraFoodUI(food.get(i).getId(), food.get(i).getImage(), food.get(i).getName(), food.get(i).getPrice());
			}
			rows = foodNumber%4==0?foodNumber/4:foodNumber/4+1;
		}};
		
		add(new JScrollPane(new JPanel() {{
			setLayout(new GridLayout(0,4,20,0));
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(new Dimension(0, 150*rows)));
            for(int i = 0; i < foodNumber; i ++) {
            	add(foodContent[i]);
            }
		}}) {{
			setBounds(40,150,870,305);
			getVerticalScrollBar().setUI(new DemoScrollBarUI()); 
		}});

		ArrayList<OriginFood> oldChoice = (ArrayList<OriginFood>)Application.context.getContext().get("ExtraFood");
		if(oldChoice != null){
			for(int i=0;i<oldChoice.size();i++){
				for(int j=0;j<foodNumber;j++){
					if(oldChoice.get(i).getFoodID() == foodContent[j].getFoodID()){
						foodContent[j].setValue(oldChoice.get(i).getCount());
					}
				}
			}
		}
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
			try {
				new ConfirmPayFrm();
				Application.context.getPageConfig().displayPage(path.resolve(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay")));
			} catch (UnboundPageException e1) {
				e1.printStackTrace();
				return;
			}
		}else{
			JOptionPane.showMessageDialog(null, "The upper limit of the food choice is 10.", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void main(String args[]) {
		ExtraFoodFrm f = new ExtraFoodFrm();
		f.setVisible(true);
	}
}