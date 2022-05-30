package com.group2022103.flightkiosk.page;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.exception.UnboundPageException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class PrintFrm extends PageFrm{
	private static final int MIN_PROGRESS = 0;
    private static final int MAX_PROGRESS = 100;
    private static int currentProgress = MIN_PROGRESS;
    private ImageIcon  image;
    public PrintFrm() {
    	super();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        image = new ImageIcon(ClassLoader.getSystemResource("image/loading.gif"));// background picture
		image.setImage(image.getImage().getScaledInstance(300,210,Image.SCALE_DEFAULT));// setSize
		JLabel picture;
		picture=new JLabel(image);
		picture.setBounds(320,80,300,200);
		add(picture);
		
		add(new JLabel("Your boarding pass, tage and ticket are printing...") {{
			setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
			setBounds(270,230,400,210);
		}});
        final JProgressBar progressBar = new JProgressBar() {{
        	setMinimum(MIN_PROGRESS);
        	setMaximum(MAX_PROGRESS);
        	setValue(currentProgress);
        	setStringPainted(true);
        	setBackground(Color.white);
        	setForeground(new Color(30, 144, 255));
        	setStringPainted(true);
        	setBounds(200,380,550,15);
        }};
        add(progressBar);

        new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentProgress++;
                progressBar.setValue(currentProgress);
                if (currentProgress >= MAX_PROGRESS) {
                    ((Timer) e.getSource()).stop();
					dispose();
					try {
						new WelcomeFrm();
						Application.context.getPageConfig().displayPage(Path.of("Welcome"));
					} catch (UnboundPageException e1) {
						e1.printStackTrace();
					}
                }
            }
        }).start();
        
    }
}
