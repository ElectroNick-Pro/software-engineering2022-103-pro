package com.group2022103.flightkiosk.component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundButtonUI extends JButton{
	private Color color, color_initial, color_pressed; // 按钮颜色和按住之后的颜色
	private Color color_border = null;// 边框颜色 默认没有边框
	private int arc = 8;// 默认弧度大小
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
		setPreferredSize(new Dimension(75, 30));// 定义按钮大小
		setFont(new Font("Microsoft YaHei UI", Font.BOLD, FontSize));// 定义按钮上的文本字体，大小
		setFocusPainted(false);// 去掉 点击按钮时，文本周边的虚线
		setContentAreaFilled(false);// 按钮本身设置为透明，只有这样才能显示出我们自己定义的颜色
		addMouseListener(new MouseAdapter() {// 通过鼠标监听来设置鼠标移入按下时，按钮颜色的变化
			public void mousePressed(MouseEvent e) {
				color = color_pressed;
			}

			public void mouseReleased(MouseEvent e) {
				color = color_initial;
			}
		});
	}
	
	public void paintComponent(Graphics g) {// 绘制填充按钮的形状：圆角矩形按钮
		Graphics2D g2d = (Graphics2D) g;
		// 以下两句，是消除圆角周边的锯齿用的
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(rh);
		// 设置填充按钮的颜色
		g2d.setColor(color);
		// 设置填充圆角矩形区域
		g2d.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, arc,
				arc);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {// 绘制按钮边框：圆角矩形边框
		if(color_border != null){
			g.setColor(color_border);
			g.drawRoundRect(0, 0, getSize().width-1, getSize().height-1,arc, arc);
		}
	}
}