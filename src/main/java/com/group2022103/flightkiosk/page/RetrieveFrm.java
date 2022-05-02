package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.component.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.*;

public class RetrieveFrm extends PageFrm{
	private JPanel contentPane,panel1,panel2,panel3;
	public RetrieveFrm(){
		super();
		setTitleName("Retrieve");
		setBackgroundImage(new ImageIcon("src/main/resources/image/travel.png"));
		
		add(new RoundButtonUI("Retrieve",new Color(0,131,255), new Color(0,105,206)){{
			setBounds(45,370,435,38);
			setForeground(Color.WHITE);
		}});

		add(panel1 = new JPanel() {{
			setBounds(45,195,435,134);
			setLayout(null);
			setBackground(Color.WHITE);
			setVisible(true);
			add(new JLabel("Please enter your booking ID:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,0,435,70);
			}});
			add(new JTextField() {{
				setBounds(1,95,435,38);
			}});
		}});
		
		add(panel2 = new JPanel() {{
			setBounds(45,150,435,193);
			setLayout(null);
			setBackground(Color.WHITE);
			setVisible(false);
			add(new JLabel("Please enter your surname:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,0,435,70);
			}});
			add(new JTextField() {{
				setBounds(1,63,435,38);
			}});
			add(new JLabel("Please enter your ID number:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,90,435,70);
			}});
			add(new JTextField() {{
				setBounds(1,155,435,38);
			}});
		}});
		
		add(panel3 = new JPanel() {{
			setBounds(45,150,341,191);
			setLayout(null);
			setVisible(false);
			setBackground(Color.WHITE);
			add(new JLabel("Please scan your ID document:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,0,341,70);
			}});
			add(new JLabel(new ImageIcon("src/main/resources/image/scanIDcard.png") {{
				setImage(this.getImage().getScaledInstance(276,126,Image.SCALE_DEFAULT));
			}}) {{
				setBackground(Color.WHITE);
				setBounds(65,65,276,126);
			}});
		}});
		
		add(new RoundButtonUI("Booking ID",Color.WHITE,new Color(226,226,226)) {{
			setForeground(Color.BLACK);
			setBorderColor(Color.BLACK);
			setARC(15);
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
			setBounds(45,435,125,38);
			addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent event){
	                panel2.setVisible(false);
	                panel3.setVisible(false);
					panel1.setVisible(true);
	            }
	        });
		}});
		
		add(new RoundButtonUI("Surname and ID",Color.WHITE,new Color(226,226,226)) {{
			setForeground(Color.BLACK);
			setBorderColor(Color.BLACK);
			setARC(15);
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
			setBounds(195,435,165,38);
			addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent event){
	                panel1.setVisible(false);
	                panel3.setVisible(false);
					panel2.setVisible(true);
	            }
	        });
		}});
		
		add(new RoundButtonUI("Scan ID",Color.WHITE,new Color(226,226,226)) {{
			setForeground(Color.BLACK);
			setBorderColor(Color.BLACK);
			setARC(15);
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
			setBounds(385,435,95,38);
			addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent event){
	                panel2.setVisible(false);
	                panel1.setVisible(false);
					panel3.setVisible(true);
	            }
	        });
		}});
	}
}
