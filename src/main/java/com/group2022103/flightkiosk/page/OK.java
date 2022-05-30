package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.component.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OK extends PageFrm {
    private JPanel contentPane;

    public OK() {
        super();
        contentPane = new JPanel() {
            {
                setLayout(null);
                setBackground(Color.WHITE);
                setSize(480, 185);
                setBackground(Color.WHITE);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                setResizable(false);
                setVisible(true);
            }
        };
        setContentPane(contentPane);

        add(new JLabel() {
            {
                setText("You Have Paid Successfully!");
                setBounds(295, 110, 35, 35);
                setVisible(true);
                setBounds(140, 44, 290, 50);
                setFont(new Font("Microsoft YaHei", Font.PLAIN, 21));
            }
        });

        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/success1.png"))) {
            {
                setBounds(25, 30, 75, 75);
                setVisible(true);
            }
        });

        add(new RoundButtonUI("OK", Color.WHITE, new Color(226, 226, 226)) {
            {
                setForeground(Color.BLACK);
                setBorderColor(Color.BLACK);
                setARC(15);
                setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
                setBounds(385, 435, 95, 38);
                addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        dispose();
                    }
                });

            }

        });
    }

}
