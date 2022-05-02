package com.group2022103.flightkiosk.component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundButtonUI extends JButton{
	private Color color, color_initial, color_pressed; // ��ť��ɫ�Ͱ�ס֮�����ɫ
	private Color color_border = null;// �߿���ɫ Ĭ��û�б߿�
	private int arc = 8;// Ĭ�ϻ��ȴ�С
	
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
	
	public void setButton(Color c_initial, Color c_pressed) {
		color = c_initial;
		color_initial = c_initial;
		color_pressed = c_pressed;
		setPreferredSize(new Dimension(75, 30));// ���尴ť��С
		setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));// ���尴ť�ϵ��ı����壬��С
		setFocusPainted(false);// ȥ�� �����ťʱ���ı��ܱߵ�����
		setContentAreaFilled(false);// ��ť��������Ϊ͸����ֻ������������ʾ�������Լ��������ɫ
		addMouseListener(new MouseAdapter() {// ͨ��������������������밴��ʱ����ť��ɫ�ı仯
			public void mousePressed(MouseEvent e) {
				color = color_pressed;
			}

			public void mouseReleased(MouseEvent e) {
				color = color_initial;
			}
		});
	}
	
	public void paintComponent(Graphics g) {// ������䰴ť����״��Բ�Ǿ��ΰ�ť
		Graphics2D g2d = (Graphics2D) g;
		// �������䣬������Բ���ܱߵľ���õ�
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(rh);
		// ������䰴ť����ɫ
		g2d.setColor(color);
		// �������Բ�Ǿ�������
		g2d.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, arc,
				arc);
		super.paintComponent(g);
	}

	public void paintBorder(Graphics g) {// ���ư�ť�߿�Բ�Ǿ��α߿�
		if(color_border != null){
			g.setColor(color_border);
			g.drawRoundRect(0, 0, getSize().width-1, getSize().height-1,arc, arc);
		}
	}
}