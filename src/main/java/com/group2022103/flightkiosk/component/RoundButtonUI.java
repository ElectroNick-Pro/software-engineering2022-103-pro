package com.group2022103.flightkiosk.component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundButtonUI extends JButton{
	private Color color, color_initial, color_pressed;
	private Color color_border = null;
	private int arc = 8;
	private int FontSize = 15;
	
	public RoundButtonUI(ImageIcon image,Color c_initial, Color c_pressed) {
		super(image);
		setButton(c_initial,c_pressed);
	}
	
	public RoundButtonUI(Color c_initial, Color c_pressed) {
		super();
		setButton(c_initial,c_pressed);
	}
	
	public RoundButtonUI(String name, Color c_initial, Color c_pressed) {
		super(name);
		setButton(c_initial,c_pressed);
	}
	
	public void setBorderColor(Color c_border){
		this.color_border = c_border;
	}

	public void setARC(int arc){
		this.arc = arc;
	}
	
	public void setFontSize(int size) {
		this.FontSize= size;
	}
	
	public void setButton(Color c_initial, Color c_pressed) {
		color = c_initial;
		color_initial = c_initial;
		color_pressed = c_pressed;
		setPreferredSize(new Dimension(75, 30));
		setFont(new Font("Microsoft YaHei UI", Font.BOLD, FontSize));
		setFocusPainted(false);
		setContentAreaFilled(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				color = color_pressed;
			}

			public void mouseReleased(MouseEvent e) {
				color = color_initial;
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(rh);
		g2d.setColor(color);
		g2d.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, arc,
				arc);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {
		if(color_border != null){
			g.setColor(color_border);
			g.drawRoundRect(0, 0, getSize().width-1, getSize().height-1,arc, arc);
		}
	}
}