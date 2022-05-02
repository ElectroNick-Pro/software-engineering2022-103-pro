package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class helpButtonUI extends JButton implements ActionListener{
	public helpButtonUI(){
		super();
		setIcon(new ImageIcon("src/main/resources/image/question.png") {{
			setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
		}});
		setBackground(Color.WHITE);
		setBorder(null);
	}

	public void actionPerformed(ActionEvent e) {

	}
}
