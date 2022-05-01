package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;

public class FlightInfoFrm extends JFrame{
	//拓展功能写在外面（里面要引用），没有拓展功能写在里面
	//定义都定义在外面，在里面不定义
	private JPanel contentPane;
	
	public FlightInfoFrm() {
		contentPane = new JPanel() {{
			setLayout(null);
		}};
		setContentPane(contentPane);
		
		add(new JLabel("Flight Information") {{
			setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
            setBounds(45, 85, 523, 49);
		}});
		add(new JLabel() {{
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
            setBounds(45, 125, 523, 49);
		}});
	}
}