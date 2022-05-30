package com.group2022103.flightkiosk.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;

import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.SeatView;
import com.group2022103.flightkiosk.vo.SeatBack;

public class SeatButtonUI extends JPanel {
    public RoundButtonUI seatChoiceBtn;
    private JLabel choose;
    private int seatId;
    private Seat seat;

    private SeatView seatView;
    private boolean isChosen = false;

    public SeatButtonUI(int seatId, int[] position) {
        super();
        this.seatId = seatId;
        this.seatView = new SeatView(new SeatBack() {{
        	setSeatId(seatId);
        	setTicketId(-1);
        	setIntervalId(-1);
        }});
        this.seat = seatView.getSeatFront().get(0);
        setLayout(null);
        setBounds(position[0], position[1], 40, 40);
        ColorUIResource[] color =  seatView.getButtonColor();
        isChosen = seatView.isChosen();
        setOpaque(false);

        add(choose = new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/success1.png"))) {{
			setBounds(0,0, 35, 35);
			setVisible(false);
			if(isChosen) {
				setVisible(true);
			}
		}});
        add(seatChoiceBtn = new RoundButtonUI(color[0],color[1]) {{
            setBounds(0,0, 35, 35);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                                
                }
            });
        }});
        
        

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
    
    public String getSeatClass() {
    	return seat.getSeatClass();
    }
}
