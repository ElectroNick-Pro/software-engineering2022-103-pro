package com.group2022103.flightkiosk.page;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.group2022103.flightkiosk.component.ConfirmButtonUI;
import com.group2022103.flightkiosk.view.OriginFood;

public class FoodChoiceFrm extends JFrame{
	private JPanel contentPane;
	private Double foodPrice = 0.0;
    public FoodChoiceFrm(ArrayList<OriginFood> allFoodChoice){
        super();
        contentPane = new JPanel() {{
			setLayout(null);
			setBackground(Color.WHITE);
		}};
		setContentPane(contentPane);
		setSize(530,570);
		setResizable(false);
		setTitle("Food Choice");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        add(new JLabel("Details of food choice"){{
            setBounds(26, 25, 360, 42);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        }});
        
        add(new JScrollPane(new JPanel() {{
			setLayout(new GridLayout(0,1,20,0));
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(415, allFoodChoice.size()*95));
            for(int i = 0; i < allFoodChoice.size(); i ++) {
            	OriginFood foodChoice = allFoodChoice.get(i);
            	ConfirmButtonUI foodBtn = new ConfirmButtonUI(foodChoice.getImage(),foodChoice.getName(),foodChoice.getPrice(),foodChoice.getCount());
            	foodPrice = foodPrice + foodChoice.getPrice()*foodChoice.getCount();
            	add(foodBtn);
            }
            if(allFoodChoice.size() < 3) {
            	for(int i = 0; i < 3 - allFoodChoice.size(); i ++) {
            		add(new JPanel() {{
            			setSize(415,85);
            			setBackground(Color.white);
            		}});
            	}
            }
		}}) {{
			if(allFoodChoice.size() > 3) {
				setBounds(40,90,433,304);
			}else {
				setBounds(40,90,418,304);
			}
			
			getVerticalScrollBar();
		}});

        add(new ConfirmButtonUI("image/pay1.png","Total",foodPrice){{
            setBounds(43,400,415,85);
        }});
        
        
	    
		setVisible(true);
    }
}
