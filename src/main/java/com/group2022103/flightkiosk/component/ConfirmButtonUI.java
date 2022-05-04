package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmButtonUI extends ConfirmPanelUI{
    public RoundButtonUI confirmButton;

    public ConfirmButtonUI(String image, String label, double price){
        super(image);
        add(new JLabel(label,SwingConstants.CENTER){{
            setBounds(113,32,190,20);
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
            setBounds(113,18,190,25);
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
            setBounds(85,32,160,20);
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

    public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.WHITE);
		f.setLayout(null);
		ConfirmButtonUI confirm1 = new ConfirmButtonUI("src/main/resources/image/knife and fork0.png","Standard","Click to see the details",0,true);
        ConfirmButtonUI confirm2 = new ConfirmButtonUI("src/main/resources/image/pay1.png","Total",34);
        ConfirmButtonUI confirm3 = new ConfirmButtonUI("src/main/resources/image/sushi8.png","Sushi",4.5,1);
        ConfirmButtonUI confirm4 = new ConfirmButtonUI("src/main/resources/image/seat1.png","Economy Class","A Seat with Extra Space",50,false);
		confirm1.setBounds(50,50,415,85);
		f.add(confirm1);
        confirm2.setBounds(50,150,415,85);
        f.add(confirm2);
        confirm3.setBounds(50,250,415,85);
        f.add(confirm3);
        confirm4.setBounds(50,350,415,85);
        f.add(confirm4);
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	    f.setSize(550,550);
		f.setVisible(true);
	}
}
