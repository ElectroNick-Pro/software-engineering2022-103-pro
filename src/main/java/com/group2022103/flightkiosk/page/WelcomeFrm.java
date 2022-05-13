package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeFrm extends PageFrm {
    public WelcomeFrm() {
        super();

        // setTitleName("Welcome");
        add(new JLabel() {
            {
                setText("Check-In Kiosk");
                setFont(new Font("Microsoft YaHei UI", Font.BOLD, 55));
                setBounds(257, 72, 445, 86);
            }
        });

        setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/welcome5.gif")));
        long time = 3000;
        TimerTask tt = new TimerTask() {
            public void run() {
                setNewBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/welcome1.jpg")));
                // System.out.println("Well");
            }
        };
        Timer timer = new Timer() {
            {
                schedule(tt, time);
            }
        };
        add(new RoundButtonUI("START", new Color(0,131,255), new Color(0,105,206)) {
            {
                setForeground(Color.WHITE);
                setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
                setBounds(391, 426, 177, 40);
                addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // turn to next page
                        System.out.println("Welcome");
                        dispose();
                        Notice frame = new Notice();
                        frame.setBackground(Color.WHITE);
                        frame.setSize(515, 600);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }

                });
            }
        });

        setSize(960, 540);
    }

    public static void main(String[] args) {
        Application.run();
        // WelcomeFrm w = new WelcomeFrm();
        // w.setLocationRelativeTo(null);
        // w.setVisible(true);
    }
}
