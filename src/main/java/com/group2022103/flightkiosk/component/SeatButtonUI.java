package com.group2022103.flightkiosk.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.group2022103.flightkiosk.component.RoundButtonUI;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.SeatView;

public class SeatButtonUI extends JPanel {
    public RoundButtonUI seatChoiceBtn;
    private JLabel choose;
    private int seatId;
    private Seat seat;
    private SeatButtonUI seatChoice;
    private SeatView seatService;

    public SeatButtonUI(int seatId, int[] position) {
        super();
        this.seatId = seatId;
        this.seatService = new SeatView(seatId);
        this.seatChoice = this;
        setLayout(null);
        setBounds(position[0], position[1], 40, 40);
        ColorUIResource[] color =  seatService.getButtonColor();
        setBackground(Color.WHITE);

        add(choose = new JLabel(new ImageIcon("src/main/resources/image/success1.png")) {{
			setBounds(0,0, 35, 35);
			setVisible(false);
		}});
        add(seatChoiceBtn = new RoundButtonUI(color[0],color[1]) {{
            setBounds(0,0, 35, 35);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chooseSeat();              
                }
            });
        }});
        
        

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
        int[] position = {100,100};
        SeatButtonUI button = new SeatButtonUI(1, position);
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }

	public void chooseSeat(){
        seatService.chooseSeat(seatChoice);
	}

    public void setChoice(){
		choose.setVisible(true);
    }

    public void cancelChoice(){
        choose.setVisible(false);
    }

    public int getSeatId(){
        return this.seatId;
    }
}
