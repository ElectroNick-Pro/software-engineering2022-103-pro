package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpinnerUI extends JPanel{
	private JTextField textField;
	private int max = 10;
	private int min = 0;
	private int step = 1;
	public SpinnerUI() {
		setLayout(null);
		setSize(90,20);
		setBackground(Color.WHITE);
		
		add(new RoundButtonUI(new ImageIcon("src/main/resources/image/reduce0.png"),Color.WHITE,new Color(226,226,226)) {{
			setBounds(0,0,20,20);
			setARC(20);
			setBorderColor(Color.GRAY);
			addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	int value;
                	if(textField.getText().equals("")) {
                		value = 0;
                	}else {
                		value = Integer.parseInt(textField.getText());
                	}
                	if(value <= min) {
                		textField.setText(""+min);
                	}else if(value > max) {
                		textField.setText(""+max);
                	}else {
                    	value -= step;
                    	textField.setText(""+value);
                	}
                }
            });
		}});
		
		add(new RoundButtonUI(new ImageIcon("src/main/resources/image/add3.png"),new Color(0,131,255), new Color(0,105,206)) {{
			setBounds(70,0,20,20);
			setARC(20);
			addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	int value;
                	if(textField.getText().equals("")) {
                		value = 0;
                	}else {
                		value = Integer.parseInt(textField.getText());
                	}
                	if(value < min) {
                		textField.setText(""+min);
                	}else if(value >= max) {
                		textField.setText(""+max);
                	}else {
                		value += step;
                    	textField.setText(""+value);
                	}
                }
            });
		}});
		
		add(textField = new JTextField() {{
			setHorizontalAlignment(JTextField.CENTER);
			setBounds(30,0,30,20);
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
			setForeground(Color.BLACK);
		}});
	}
	
	public int getValue() {
		int value;
    	if(textField.getText().equals("")) {
    		value = 0;
    	}else {
    		value = Integer.parseInt(textField.getText());
    	}
		if(value > max) {
			return max;
		}else if(value < min) {
			return min;
		}else {
			return value;
		}
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.WHITE);
		f.setLayout(null);
		SpinnerUI s = new SpinnerUI();
		s.setBounds(50,50,90,20);
		f.add(s);
		f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
//	    f.setLocationRelativeTo(null); 
	    f.setSize(250,200);
		f.setVisible(true);
	}
}
