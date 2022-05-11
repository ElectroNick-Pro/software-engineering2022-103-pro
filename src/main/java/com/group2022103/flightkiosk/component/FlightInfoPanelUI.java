package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;

public class FlightInfoPanelUI extends JPanel{
	private ImageIcon image;
    private JLabel bookID, date, airlineLabel, takeoff, arrive, flightNo, airport1, airport2, startTime, arriveTime, time, seat,
            food,Terminal, TerminalNum, GateNo, Gate, name, ID, picture, seatClass, classNo, foodChoice;
    public FlightInfoPanelUI(String flightbookID, String flightDate, String airline,String flightTakeoff, String flightArrive,
    	    String flightFlightNo, String flightAirport1, String flightAirport2, String flightStartTime,
    	    String flightArriveTime,String fightTime, String flightSeat, String flightFood, String FlightTerminalNum, 
    	    String flightGateNo,String flightName,String fligthNameID) {
    	var panel = this;
    	panel.setBorder(new RoundBorderUI(Color.GRAY));
    	panel.setOpaque(false);
    	
    	bookID = new JLabel("Booking ID "+flightbookID,JLabel.LEFT) {{
    		setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 15));
    	}};   	

    	date = new JLabel(flightDate,JLabel.RIGHT) {{
    		setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 15));
    	}};

    	airlineLabel = new JLabel(airline) {{
    		setFont(new Font("Microsoft YaHei UI", Font.ITALIC, 20));
    	}};

    	image = new ImageIcon(ClassLoader.getSystemResource("image/airplane.png"));
    	image.setImage(image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    	picture = new JLabel(image);

    	takeoff = new JLabel(flightTakeoff, JLabel.LEFT) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    	}};

    	arrive = new JLabel(flightArrive, JLabel.RIGHT) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    	}};
    	        

    	flightNo = new JLabel("Flight NO. "+flightFlightNo,JLabel.RIGHT) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
    	}};

    	airport1 = new JLabel(flightAirport1, JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
    	}};

    	airport2 = new JLabel(flightAirport2,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
    	}};

    	startTime = new JLabel(flightStartTime,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
    	}};

    	arriveTime = new JLabel(flightArriveTime,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
    	}};

    	time = new JLabel("--"+fightTime+"--",JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
    		setForeground(Color.GRAY);
    	}};

    	seat = new JLabel(flightSeat, JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
    	}};

    	food = new JLabel(flightFood, JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
    	}};

    	Terminal = new JLabel("Terminal",JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
    	}};

    	TerminalNum = new JLabel(FlightTerminalNum,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    	}};

    	GateNo = new JLabel(flightGateNo,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 25));
    	}};

    	Gate = new JLabel("Gate",JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));

    	}};
    	name = new JLabel(flightName,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
    	}};

    	ID = new JLabel(fligthNameID,JLabel.CENTER) {{
    		setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
    	}};
    }

    public JLabel getFlightClass(String flightClass) {
    	if(flightClass == "Nomal") {
    		seatClass = new JLabel("Economy Class");
    	}
    	else {
    		seatClass = new JLabel("First Class");
    	}
    	 seatClass.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
    	 seatClass.setForeground(new Color(0,131,255));
    	 seatClass.setBackground(new Color(30, 144, 255));
    	 return seatClass;
   }

   public JLabel getFlightSeat(String seatNo) {
    	 classNo = new JLabel(seatNo);
    	 classNo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
    	 classNo.setForeground(new Color(0,131,255));
    	 classNo.setBackground(new Color(30, 144, 255));
    	 return classNo;
   }

    	    
   public JLabel getFoodType(String foodType) {
	   foodChoice = new JLabel(foodType);
	   foodChoice.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
	   foodChoice.setForeground(new Color(0,131,255));
	   foodChoice.setBackground(new Color(30, 144, 255));
	   return foodChoice; 	    
   }

   public void checkLayout(String flightClass,String seatNo,String foodType){
	   seatClass=getFlightClass(flightClass);
	   classNo=getFlightSeat(seatNo);
	   foodChoice=getFoodType(foodType);
	   classNo.setBounds(300,285, 75, 25);
	   seatClass.setBounds(255, 315, 200, 25);
	   foodChoice.setBounds(25,190,100,100);
	   Layout();
	   seat.setVisible(false);
	   food.setVisible(false);
	   name.setBounds(20, 275, 180, 42);
	   ID.setBounds(20, 305, 200, 42);
	   this.add(classNo);
	   this.add(foodChoice);
	   this.add(seatClass);
   }

   public void Layout() {
    	 // book,bookID,date,where,takeoff,arrive,flightNo,airport1,airport2,startTime,arriveTime,time,seat,food,
    	 // Terminal,TerminalNum,GateNo,Gate,name,ID,picture,seatClass,classNo,foodChoice
    	 bookID.setBounds(20, 15, 300, 30);
    	 date.setBounds(280, 15, 120, 30);
    	 airlineLabel.setBounds(20, 37, 150, 50);
    	 takeoff.setBounds(20, 84, 150, 42);
    	 arrive.setBounds(250, 84, 150, 42);
    	 flightNo.setBounds(250, 37, 150, 50);
    	 airport1.setBounds(10, 135, 120, 20);
    	 airport2.setBounds(270, 135, 150, 20);
    	 startTime.setBounds(15, 174, 100, 32);
    	 arriveTime.setBounds(300, 174, 100, 32);
    	 time.setBounds(165, 180, 100, 17);
    	 seat.setBounds(20, 210, 100, 32);
    	 food.setBounds(20, 232, 98, 32);
    	 Terminal.setBounds(160, 240, 100, 25);
    	 TerminalNum.setBounds(180, 218, 50, 21);
    	 GateNo.setBounds(310, 218, 80, 21);
    	 Gate.setBounds(310, 240, 80, 25);
    	 name.setBounds(120, 280, 180, 42);
    	 ID.setBounds(120, 320, 200, 42);
    	 picture.setBounds(183, 80, 50, 50);

    	 this.setLayout(null);
    	 this.add(bookID);
    	 this.add(date);
    	 this.add(airlineLabel);
    	 this.add(takeoff);
    	 this.add(arrive);
    	 this.add(flightNo);
    	 this.add(airport1);
    	 this.add(airport2);
    	 this.add(startTime);
    	 this.add(arriveTime);
    	 this.add(time);
    	 this.add(seat);
    	 this.add(food);
    	 this.add(Terminal);
    	 this.add(TerminalNum);
    	 this.add(GateNo);
    	 this.add(Gate);
    	 this.add(name);
    	 this.add(ID);
    	 this.add(picture);
   }
}
