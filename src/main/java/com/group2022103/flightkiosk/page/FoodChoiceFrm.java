package com.group2022103.flightkiosk.page;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.group2022103.flightkiosk.component.ConfirmButtonUI;
import com.group2022103.flightkiosk.component.DemoScrollBarUI;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.view.OriginFood;

public class FoodChoiceFrm extends JFrame{
	private ArrayList<OriginFood> allFoodChoice;
    public FoodChoiceFrm(ArrayList<OriginFood> allFoodChoice){
        super();
        this.allFoodChoice = allFoodChoice;

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
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.white);
		setResizable(false);
	    setSize(530,570);
		setVisible(true);
    }
}
