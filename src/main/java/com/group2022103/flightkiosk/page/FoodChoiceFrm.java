package com.group2022103.flightkiosk.page;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.group2022103.flightkiosk.component.ConfirmButtonUI;
import com.group2022103.flightkiosk.component.DemoScrollBarUI;
import com.group2022103.flightkiosk.model.FoodPurchase;

public class FoodChoiceFrm extends PageFrm{
    private JPanel contentPane;
    public FoodChoiceFrm(){
        super();
        
        contentPane = new JPanel() {{
            setLayout(null);
            setBackground(Color.WHITE);
        }};
        setContentPane(contentPane);

        add(new JLabel("Details of food choice"){{
            setBounds(26, 25, 360, 42);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        }});
        add(new JScrollPane(new JPanel() {{
			setLayout(new GridLayout(0,1,20,0));
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(415, 5*105));
            for(int i = 0; i < 5; i ++) {
            	ConfirmButtonUI foodBtn = new ConfirmButtonUI("src/main/resources/image/sushi8.png","Sushi",4.5,1);
            	add(foodBtn);
            }
		}}) {{
            setBounds(40,90,440,304);
			getVerticalScrollBar();
		}});

        add(new ConfirmButtonUI("src/main/resources/image/pay1.png","Total",34){{
            setBounds(43,400,415,85);
        }});
        
        setTitle("Food Choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	    setSize(530,570);
		setVisible(true);
    }

    public void setBackAction() {
		System.out.println("back");
	}
	
	public void setNextAction() {
		System.out.println("next");
	}
}
