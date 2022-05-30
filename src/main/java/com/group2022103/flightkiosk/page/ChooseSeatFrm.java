package com.group2022103.flightkiosk.page;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.FlightInfoView;
import com.group2022103.flightkiosk.view.SeatChoice;
import com.group2022103.flightkiosk.view.SeatView;
import com.group2022103.flightkiosk.vo.SeatBack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.List;

public class ChooseSeatFrm extends PageFrm{
    private Path path = Path.of("/Retrieve/Flight Information/Choose Seat");
    private SeatView seatView;
    private List<Seat> seats;
    //colors for buttons of hints
    private ColorUIResource[] iconColor = {new ColorUIResource(249,237,166), new ColorUIResource(209,245,252), new ColorUIResource(102,178,91), new ColorUIResource(205,205,205), new ColorUIResource(255,215,185), new ColorUIResource(253,231,201)}; 
    private int[] btnHintPosition = {295,70,455,70,295,110,455,110,646,70,646,110};
    private int[] textHintPosition = {340,73,80,25,
                                        500,73,112,25,
                                        340, 112,90,25,
                                        498,112,132,25,
                                        700,64,165,25,
                                        701,79,165,25,
                                        700,106,165,25,
                                        701,119,165,25};
    private String[] hintText = {"First Class", "Economy Class", "Your choice", "Unable to choose", "First Class Seat", "with Extra Space", "Economy Class Seat", "with Extra Space"};
    private int i = 0, j = 0, k = 0, x = 0, y = 0;
    private int frameWidth = 965;
    private int seatWidth = frameWidth - 150;
    private int seatHeight = 280;
    private int aisle_space = 30;
    private int rowLength;
    private int columnLength;
    private int row_spacing;
    private int column_spacing;
    private int btnWidth = 35, btnHeight = 35;

    private int seatId = -1;
    private int intervalId = 1;
    private SeatButtonUI seatChoiceBtn;
    private boolean canChoose = true;
    private String originSeatClass;
    private SeatChoice chosenSeat;
    private SeatButtonUI chosenSeatButton;
    
    public ChooseSeatFrm(){
        super();
        Application.context.getPageConfig().bindPage(this.path, this);
        Application.context.getContext().put("curPath",this.path);
        this.intervalId = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getIntervalID();
        this.originSeatClass = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getSeatClass();
        if(Application.context.getContext().get("SeatChoice") != null) {
        	chosenSeat = (SeatChoice)Application.context.getContext().get("SeatChoice");
        }
        seatView = new SeatView(new SeatBack() {{
        	setTicketId(-1);
        	setIntervalId(intervalId);
        	setSeatId(-1);
        }});
        canChoose = seatView.canChooseSeat();
        rowLength = seatView.getRowLength();
        columnLength = seatView.getColumnLength();
        System.out.println("Line 81: row length = "+rowLength+" column length = "+columnLength);
        row_spacing = (seatWidth - rowLength * 35 ) / rowLength;
        column_spacing = (seatHeight - columnLength * 35 - aisle_space) / columnLength;
        
        
        add(new BreadCrumbUI(path){{
			setBounds(80,25,800,25);
		}});

        //buttons of hints
        for(i = 0; i < 6; i ++){
            if(i == 2){
                continue;
            }
            int X = this.btnHintPosition[2*i];
            int Y = this.btnHintPosition[2*i + 1];
            add(new RoundButtonUI(this.iconColor[i],this.iconColor[i]) {{
                setContentAreaFilled(false);
                setBounds(X, Y, 30, 30);
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setEnabled(false);
                    }
                });
            }});
        }
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/success1.png"))) {{
			setBounds(295,110, 35, 35);
			setVisible(true);
		}});

        //texts of hints
        for(i = 0; i < 8; i ++){
            int X = this.textHintPosition[4*i];
            int Y = this.textHintPosition[4*i + 1];
            int Width = this.textHintPosition[4*i + 2];
            int Height = this.textHintPosition[4*i + 3];
            add(new JLabel(this.hintText[i]){{
                if(i < 4){
                    setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                }else{
                    setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
                }
                setBounds(X, Y, Width, Height);
            }});
        }

        //seat buttons
        seatView = new SeatView(new SeatBack() {{
        	setIntervalId(intervalId);
        	setSeatId(-1);
        	setTicketId(-1);
        }});
        seats = seatView.getAllSeats();
        Seat seat;
        for(i = 0, j = 0, k = 0; k < seats.size(); k ++){
        	seat = seats.get(k);
            int rowNo = seat.getRowNo() - 1;
            int columnNo = seat.getColumnNo() - 1;
            x = 75 + rowNo * btnWidth + rowNo * row_spacing;
            y = 180 + columnNo * btnHeight+ columnNo * column_spacing;
            if(j >= (columnLength / 2)){
                y = y + aisle_space;
            }
            int[] position = {x,y};
            SeatButtonUI seatBtn = new SeatButtonUI(seat.getId(), position);
            if(chosenSeat != null) {
            	if(chosenSeat.getSeatId() == seatBtn.getSeatId() && chosenSeat.getIntervalId() == intervalId) {
            		seatBtn.setChoice();
            		chosenSeatButton = seatBtn;
            	}
            }
            add(seatBtn);
            seatBtn.seatChoiceBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(seatChoiceBtn != null){ //have chosen a seat before
                        seatChoiceBtn.cancelChoice();
                    }
                    if(originSeatClass.equals("First Class") && seatBtn.getSeatClass().equals("Normal")) {
                    	System.out.println("inside");
                    	JOptionPane.showMessageDialog(null, "Please choose a First-Class seat!", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                    	if(canChoose) {
                    		if(chosenSeatButton != null) {
                    			chosenSeatButton.cancelChoice();
                    		}
                    		seatId = seatBtn.getSeatId();
                    		seatView = new SeatView(new SeatBack() {{
                            	setTicketId(-1);
                            	setIntervalId(-1);
                            	setSeatId(seatId);
                            }});
                    		if(seatView.getSeatStatus() == 1) {
                    			JOptionPane.showMessageDialog(null, "Sorry, this seat has been chosen by others!\nPlease choose another one.", "Error", JOptionPane.ERROR_MESSAGE);
                    		}else if(seatView.getSeatStatus() == 0) {
                    			seatChoiceBtn = seatBtn;
                                seatBtn.setChoice();
                                seatView.chooseSeat(seatBtn);
                    		}
                        }else {
                        	JOptionPane.showMessageDialog(null, "You have already choose a seat!\nPlease don't choose again!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } 
            });

            if(i == 0){
                String column = "";
            	switch(seat.getColumnNo()) {
            		case 1:
            			column = "A";
            			break;
            		case 2:
            			if(columnLength == 4) {
            				column = "C";
            			}else if(columnLength == 6) {
            				column = "B";
            			}
            			break;
            		case 3:
            			if(columnLength == 4) {
            				column = "D";
            			}else if(columnLength == 6) {
            				column = "C";
            			}
            			break;
            		case 4:
            			if(columnLength == 4) {
            				column = "F";
            			}else if(columnLength == 6) {
            				column = "D";
            			}
            			break;
            		case 5:
            			column = "E";
            			break;
            		case 6:
            			column = "F";
            			break;
            	}
                add(new JLabel(column){{
                    setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
                    setBounds(45,y+6,20,20);
                }});
                System.out.println(column);
            }
            if(j == 0){
                add(new JLabel(i+1+""){{
                    setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
                    setBounds(x+12,145,20,20);
                }});
            }
            if(j == columnLength - 1){
                j = 0;       
                i ++;             
            }else{
                j ++;
            }
        }

        setTitleName("Choose Seat");
		setBackButton();
		setNextButton();
        addExitButton();
		addHelpButton();
    }
	
	public void setNextAction() {		
		//check if user choose a seat
		SeatChoice seatChoice = (SeatChoice)Application.context.getContext().get("SeatChoice");
        if(seatChoice == null){
            JOptionPane.showMessageDialog(null, "Please choose a seat before jumping to the next page", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else {
        	int intervalId = seatChoice.getIntervalId();
    		int ticketId = seatChoice.getTicketId();
    		int seatId = seatChoice.getSeatId();
    		int columnNo = seatChoice.getColumnNo();
    		int rowNo = seatChoice.getRowNo();
    		String seatNo = seatChoice.getSeatNo();
    		String seatClass = seatChoice.getSeatClass();
    		String type = seatChoice.getType();
    		Double price = seatChoice.getPrice();
    		boolean upgrade = seatChoice.isUpgrade();
    		
    		System.out.println("intervalId: "+intervalId);
    		System.out.println("ticketId: "+ticketId);
    		System.out.println("seatId: "+seatId);
    		System.out.println("columnNo: "+columnNo);
    		System.out.println("rowNo: "+rowNo);
    		System.out.println("seatNo: "+seatNo);
    		System.out.println("seatClass: "+seatClass);
    		System.out.println("type: "+type);
    		System.out.println("price: "+price);
    		System.out.println("upgrade: "+upgrade);
    		
    		try {
    			new ChooseFoodFrm();
    			Application.context.getPageConfig().displayPage(path.resolve(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food")));
    		} catch (UnboundPageException e1) {
    			e1.printStackTrace();
    			return;
    		}
        }
	}
    
}
