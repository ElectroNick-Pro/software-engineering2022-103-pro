package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;

public class PageFrm extends JFrame{
	private JPanel contentPane;
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
	}

	public void addExitButton(){
		add(new JButton() {{
			setIcon(new ImageIcon(ClassLoader.getSystemResource("image/exit.png")) {{
				setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
			}});
			setBackground(Color.WHITE);
			setBorder(null);
			setBounds(40,20,40,40);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setExitAction();
				}
			});
		}});
	}

	public void addHelpButton(){
		add(new JButton() {{
			setIcon(new ImageIcon(ClassLoader.getSystemResource("image/question.png")) {{
				setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
			}});
			setBackground(Color.WHITE);
			setBorder(null);
			setBounds(880,20,40,40);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Helpnotice frame = new Helpnotice();
					frame.setBackground(Color.WHITE);
					frame.setSize(515, 600);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
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
		add(new RoundButtonUI("Back", new Color(198,198,198), new Color(148,148,148)) {{
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
		add(new RoundButtonUI("Next", new Color(0,131,255), new Color(0,105,206)) {{
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
		System.out.println("back");
		try {
			Application.context.getPageConfig().goBack();
		} catch (UnboundPageException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setNextAction() {
	}

	public void setExitAction(){
		try {
			new WelcomeFrm();
			Application.context.getPageConfig().displayPage((Path.of("Welcome")));
		} catch (UnboundPageException e1) {
			e1.printStackTrace();
			return;
		}
	}
	
	public void setBackgroundImage(ImageIcon image) {
		contentPane.add(backgroundImage = new JLabel(image) {{
			setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		}}, JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false);
        getLayeredPane().setLayout(null);
        getLayeredPane().add(backgroundImage, Integer.valueOf(Integer.MIN_VALUE));
        getLayeredPane().setBackground(Color.WHITE);
	}
		
	public void setNewBackgroundImage(ImageIcon image) {
		contentPane.add(backgroundImage = new JLabel(image) {{
			setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		}}, JLayeredPane.DEFAULT_LAYER);
        contentPane.setOpaque(false);
        getLayeredPane().setLayout(null);
        getLayeredPane().add(backgroundImage,Integer.valueOf(Integer.MIN_VALUE+1));
        getLayeredPane().setBackground(Color.WHITE);
	}
}