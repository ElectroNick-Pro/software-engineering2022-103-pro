package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group2022103.flightkiosk.component.*;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeFrm extends PageFrm {
    public WelcomeFrm() {
        super();

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
            }
        };
        new Timer() {
            {
                schedule(tt, time);
            }
        };
        add(new RoundButtonUI("START", new Color(0, 131, 255), new Color(0, 105, 206)) {
            {
                setForeground(Color.WHITE);
                setFont(new Font("Microsoft YaHei UI", Font.BOLD, 30));
                setBounds(284, 426, 177, 40);
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
        add(new RoundButtonUI("check-in status", new Color(198, 198, 198), new Color(148, 148, 148)) {
            {
                setForeground(Color.WHITE);
                setFont(new Font("Microsoft YaHei UI", Font.BOLD, 22));
                setBounds(500, 426, 200, 40);
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        BackAllFlightFrm frame = new BackAllFlightFrm();
                        frame.setBackground(Color.WHITE);
                        frame.setSize(965, 550);
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    }
                });
            }
        });
        setSize(960, 540);
    }
}
