package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exitButtonUI extends JButton implements ActionListener{
	public exitButtonUI(){
		super();
		setIcon(new ImageIcon(ClassLoader.getSystemResource("image/exit.png")) {{
			setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
		}});
		setBackground(Color.WHITE);
		setBorder(null);
	}

	public void actionPerformed(ActionEvent e) {
//		����������һ��ҳ��͵�����ʾ
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit? If so, your choices will not be saved.", "Confirm", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION){
//            TODO - RetrieveFrmҳ����������� + GlobalData��� + ���ص���ӭҳ��
        }
	}
}
