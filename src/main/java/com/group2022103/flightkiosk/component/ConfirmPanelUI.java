package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmPanelUI extends JPanel{
    public ConfirmPanelUI(String image){
        setLayout(null);
		setSize(415,85);
		setBackground(Color.WHITE);

        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource(image))) {{
			setBackground(Color.WHITE);
			setBounds(20,13,50,50);
		}});


    }
}
