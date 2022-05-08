package com.group2022103.flightkiosk.page;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.RowMapper;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.RoundButtonUI;
import com.group2022103.flightkiosk.component.SeatButtonUI;
import com.group2022103.flightkiosk.controller.SeatController;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.view.SeatChoice;
import com.group2022103.flightkiosk.view.SeatView;
import com.group2022103.flightkiosk.vo.SeatBack;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class ChooseSeatFrm extends PageFrm{
    private Path path = Path.of("/Retrieve/Flight Information/Choose Seat");
    private ColorUIResource[] iconColor = {new ColorUIResource(255,239,0),
                                            new ColorUIResource(169,242,255),
                                            new ColorUIResource(102,178,91),
                                            new ColorUIResource(151,151,151),
                                            new ColorUIResource(255,115,0),
                                            new ColorUIResource(255,189,52)}; //colors for buttons of hints
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
    private ColorUIResource[] seatBtnColor = new ColorUIResource[2];
    private int i = 0, j = 0, k = 0, x = 0, y = 0;
    private int frameWidth = 965;
    private int frameHeight = 550;
    private int seatWidth = frameWidth - 150;
    private int seatHeight = 280;
    private int aisle_space = 30;
    private int rowLength = 14;
    private int columnLength = 4;
    private int row_spacing = (seatWidth - rowLength * 35 ) / rowLength;
    private int column_spacing = (seatHeight - columnLength * 35 - aisle_space) / columnLength;
    private int btnWidth = 35, btnHeight = 35;
    private int seatNum = 60;

    private JPanel contentPane;
    private int seatId = -1;
    private int intervalId = 1;
    private SeatButtonUI seatChoiceBtn;
    private SeatView seatView = new SeatView(new SeatBack());
    
    public ChooseSeatFrm(){
        super();
        
        Application.context.getPageConfig().bindPage(this.path, this);

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
        add(new JLabel(new ImageIcon("src/main/resources/image/success1.png")) {{
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

        for(i = 0, j = 0; i < this.rowLength;){
            int rowNo = i % this.rowLength;
            int columnNo = j % this.columnLength;
            x = 75 + rowNo * btnWidth + rowNo * row_spacing;
            y = 180 + columnNo * btnHeight+ columnNo * column_spacing;
            if(j >= (columnLength / 2)){
                y = y + aisle_space;
            }
            int[] position = {x,y};
            SeatButtonUI seatBtn = new SeatButtonUI(j+i*this.columnLength, position);
            add(seatBtn);
            seatBtn.seatChoiceBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(seatChoiceBtn != null){ //have chosen a seat before
                        seatChoiceBtn.cancelChoice();
                    }
                    //check if he can change seat
                    seatChoiceBtn = seatBtn;
                    seatId = seatBtn.getSeatId();
                    seatBtn.setChoice();
                    seatView.chooseSeat(seatBtn);
                } 
            });

            if(i == 0){
                String column = "";
                if((j+1) == 1){
                    column = "A";
                }else if((j+1) == 2 && (j+1) != columnLength / 2 ){
                    column = "B";
                }else if((j+1) == columnLength/2){
                    column = "C";
                }else if((j+1) == columnLength / 2 + 1){
                    column = "D";
                }else if((j+1) == columnLength - 1){
                    column = "E";
                }else if((j+1) == columnLength){
                    column = "F";
                }
                add(new JLabel(column){{
                    setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
                    setBounds(45,y+6,20,20);
                }});
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
		setBackgroundImage(new ImageIcon("src/main/resources/image/backgroundAirplane.png"));

        setTitle("Choose Seat");
    }
	
	public void setNextAction() {
		System.out.println("next");
		
		//save user's choice in GlobalData
		SeatChoice seatChoice = (SeatChoice)Application.context.getContext().get("SeatChoice");
        if(seatChoice == null){
            JOptionPane.showMessageDialog(null, "Please choose a seat before jumping to the next page", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
		int intervalId = seatChoice.getIntervalId();
		int ticketId = seatChoice.getTicketId();
		int seatId = seatChoice.getTicketId();
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
	public static void main(String args[]) {
//		Application.run();
		ChooseSeatFrm f = new ChooseSeatFrm();
	}
    
}
