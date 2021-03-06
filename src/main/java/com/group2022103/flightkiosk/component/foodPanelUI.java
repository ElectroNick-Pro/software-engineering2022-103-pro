package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;

public class foodPanelUI extends JPanel{
	public foodPanelUI(String image,String name) {
		setLayout(null);
		setSize(200,150);
		setBackground(Color.WHITE);

		System.out.println(image);
		
		add(new JLabel(new ImageIcon(ClassLoader.getSystemResource(image))) {{
			setBackground(Color.WHITE);
			setBounds(75,0,60,60);
		}});
		
		add(new JLabel(name,SwingConstants.CENTER) {{
			setBounds(0,55,200,50);
			setFont(new Font("Microsoft YaHei UI",Font.BOLD,23));
		}});
	}
}
