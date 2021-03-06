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
		
		add(new RoundButtonUI(new ImageIcon(ClassLoader.getSystemResource("image/reduce0.png")),Color.WHITE,new Color(226,226,226)) {{
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
		
		add(new RoundButtonUI(new ImageIcon(ClassLoader.getSystemResource("image/add3.png")),new Color(0,131,255), new Color(0,105,206)) {{
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
		return value;
	}

	public void setValue(int value){
		textField.setText(""+value);
	}
}
