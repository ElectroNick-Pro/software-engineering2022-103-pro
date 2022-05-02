package com.group2022103.flightkiosk.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exitButtonUI extends JButton implements ActionListener{
	public exitButtonUI(){
		super();
		setIcon(new ImageIcon("src/main/resources/image/exit.png") {{
			setImage(this.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
		}});
		setBackground(Color.WHITE);
		setBorder(null);
	}

	public void actionPerformed(ActionEvent e) {
//		如果不是最后一个页面就弹窗提示
		int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit? If so, your choices will not be saved.", "Confirm", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION){
//            TODO - RetrieveFrm页面的输入框都清空 + GlobalData清空 + 返回到欢迎页面
        }
	}
}
