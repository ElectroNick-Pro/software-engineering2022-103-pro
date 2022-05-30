package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;

public class ConfirmButtonUI extends ConfirmPanelUI{
    public RoundButtonUI confirmButton;

    public ConfirmButtonUI(String image, String label, double price){
        super(image);
        add(new JLabel(label,SwingConstants.CENTER){{
            setBounds(113,22,190,40);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        }});
        if(price == 0.0) {
			add(new JLabel("FREE",SwingConstants.CENTER) {{
				setBounds(320,30,75,25);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(0,131,255));
			}});
		}else {
			add(new JLabel("$"+price,SwingConstants.CENTER) {{
				setBounds(320,30,75,25);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(226,37,37));
			}});	
		}
        add(confirmButton = new RoundButtonUI(Color.WHITE,Color.WHITE) {{
			setBorderColor(Color.GRAY);
			setBounds(0,0,414,84);
		}});
    }

    public ConfirmButtonUI(String image, String label1,String label2, double price,boolean isClickable) {
        super(image);
        add(new JLabel(label1,SwingConstants.CENTER){{
            setBounds(113,8,190,45);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        }});
        add(new JLabel(label2,SwingConstants.CENTER){{
            setBounds(113,50,190,20);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
        }});
        if(price == 0.0) {
			add(new JLabel("FREE",SwingConstants.CENTER) {{
				setBounds(320,30,75,25);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(0,131,255));
			}});
		}else {
			add(new JLabel("$"+price,SwingConstants.CENTER) {{
				setBounds(320,30,75,25);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(226,37,37));
			}});	
		}
        if(isClickable){
            add(confirmButton = new RoundButtonUI(Color.WHITE,new Color(226,226,226)) {{
                setBorderColor(Color.GRAY);
                setBounds(0,0,414,84);
            }});
        }else{
            add(confirmButton = new RoundButtonUI(Color.WHITE,Color.WHITE) {{
                setBorderColor(Color.GRAY);
                setBounds(0,0,414,84);
            }});
        }
    }

    public ConfirmButtonUI(String image,String label,double price,int count){
        super(image);
        add(new JLabel(label,SwingConstants.CENTER){{
            setBounds(85,22,190,40);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        }});
        if(price == 0.0) {
			add(new JLabel("FREE",SwingConstants.CENTER) {{
				setBounds(252,30,75,25);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(0,131,255));
			}});
		}else {
			add(new JLabel("$"+price,SwingConstants.CENTER) {{
				setBounds(252,30,75,25);
				setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
				setForeground(new Color(226,37,37));
			}});	
		}
        add(new JLabel("x"+ count,SwingConstants.CENTER){{
            setBounds(330,30,67,25);
			setFont(new Font("Microsoft YaHei UI",Font.BOLD,20));
            setForeground(new Color(0,131,255));
        }});
        add(confirmButton = new RoundButtonUI(Color.WHITE,Color.WHITE) {{
			setBorderColor(Color.GRAY);
			setBounds(0,0,414,84);
		}});
    }
}