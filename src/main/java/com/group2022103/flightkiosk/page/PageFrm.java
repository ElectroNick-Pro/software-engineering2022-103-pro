package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.group2022103.flightkiosk.component.*;

public class PageFrm extends JFrame{
	private JPanel contentPane;
	private RoundButtonUI back,next;
	private JLabel backgroundImage;
	public PageFrm() {
		contentPane = new JPanel() {{
			setLayout(null);
			setBackground(Color.WHITE);
		}};
		setContentPane(contentPane);
		setSize(965,550);
		setResizable(false);
		setTitle("Check-In Kiosk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JButton() {{
			setIcon(new ImageIcon("src/main/resources/image/exit.png") {{
				setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
			}});
			setBackground(Color.WHITE);
			setBorder(null);
			setBounds(40,20,40,40);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}});
		
		add(new JButton() {{
			setIcon(new ImageIcon("src/main/resources/image/question.png") {{
				setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
			}});
			setBackground(Color.WHITE);
			setBorder(null);
			setBounds(880,20,40,40);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}});
	}
	
	public void setTitleName(String title) {
		add(new JLabel(title) {{
			setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
            setBounds(45, 75, 523, 49);
		}});
	}
	
	public void setHintName(String hint) {
		add(new JLabel(hint) {{
			setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
            setBounds(45, 110, 523, 49);
		}});
	}
	
	public void setBackButton() {
		add(back = new RoundButtonUI("Back", new Color(198,198,198), new Color(148,148,148)) {{
			setForeground(Color.WHITE);
			setBounds(25,460,75,30);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setBackAction();
				}
			});
		}});
	}
	
	public void setNextButton() {
		add(next = new RoundButtonUI("Next", new Color(0,131,255), new Color(0,105,206)) {{
			setForeground(Color.WHITE);
			setBounds(850,460,75,30);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setNextAction();
				}
			});
		}});
	}
	
	public void setBackAction() {
	}
	
	public void setNextAction() {
	}
	
	public void setBackgroundImage(ImageIcon image) {
		contentPane.add(backgroundImage = new JLabel(image) {{
			setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		}}, JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false);
        this.getLayeredPane().setLayout(null);
        this.getLayeredPane().add(backgroundImage, new Integer(Integer.MIN_VALUE));
        this.getLayeredPane().setBackground(Color.WHITE);
	}
}
