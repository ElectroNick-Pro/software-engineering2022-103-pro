package com.group2022103.flightkiosk.component;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

import javax.swing.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.exception.UnboundPageException;

public class HrefButtonUI extends JButton{
    private Path path;  
    public HrefButtonUI(Path path){
        super();
        this.path = path;
        setText(path.getName(path.getNameCount()-1).toString());
        setFont(new Font("Microsoft YaHei UI",Font.BOLD,15));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
        setFocusPainted(false);
        setBackground(Color.WHITE);
        addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                navigateTo();
            }
        });
        addMouseListener(new MouseAdapter() {
            private Color defaultColor;
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(0,131,255));
                defaultColor = getForeground();
			}

			public void mouseExited(MouseEvent e) {
				setForeground(defaultColor);
			}
		});
    }

    public void navigateTo(){
        System.out.println(path);
        try {
            Application.context.getPageConfig().displayPage(path);
        } catch (UnboundPageException e1) {
            e1.printStackTrace();
        } 
    }
}
