package com.group2022103.flightkiosk.component;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
 
import javax.swing.border.Border;
 
/**
 * Swing
 * ����Բ�Ǳ߿򣨿����Զ���߿����ɫ��
 * ����Ϊbutton���ı��������������ӱ߿�
 * ʹ�÷�����
 * JButton close = new JButton(" �� �� ");
 * close.setOpaque(false);// ����ԭ����ť����͸��
 * close.setBorder(new RoundBorder());��ɫ��Բ�Ǳ߿�
 * close.setBorder(new RoundBorder(Color.RED)); ��ɫ��Բ�Ǳ߿�
 * new color();
 * 
 */

public class RoundBorderUI implements Border{
	private Color color;
	 
	public RoundBorderUI(Color color) {// �в����Ĺ��췽��
		this.color = color;
	}
	 
	public RoundBorderUI() {// �޲ι��췽��
		this.color = Color.BLACK;
		// ���ʵ����ʱ��û�д�ֵ
		// Ĭ���Ǻ�ɫ�߿�
	}
	public Insets getBorderInsets(Component c) {
		return new Insets(0, 0, 0, 0);
	}
	 
	public boolean isBorderOpaque() {
		return false;
	}
	 
	// ʵ��Border�����ࣩ����
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		g.setColor(color);
		g.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 15, 15);
	}	    
}
