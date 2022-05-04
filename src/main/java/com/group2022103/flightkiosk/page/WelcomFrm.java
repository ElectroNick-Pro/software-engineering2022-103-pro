package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.group2022103.flightkiosk.component.*;

public class WelcomFrm extends PageFrm{
    private WelcomFrm(){
        super();
       
        //setTitleName("Welcome");
        add(new JLabel(){
            {
                setText("Check-In Kiosk");
                setFont(new Font("Microsoft YaHei UI",Font.BOLD,55));
                setBounds(257,72,445,86);
            }
        });
        setBackgroundImage(new ImageIcon("src/main/resources/image/backgroundAirplane.png"));
        add(new RoundButtonUI("START", new Color(0,131,255), new Color(0,105,206)){
            {
                setForeground(Color.WHITE);
                setFont(new Font("Microsoft YaHei UI",Font.BOLD,30));
                setBounds(391,426,177,40);
                addActionListener(new ActionListener() {
        
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //turn to next page
                        System.out.println("Welcome");
                    }
                    
                });
            }
        });

        setSize(960,540);
    }
    public static void main (String[] args){
        WelcomFrm w=new WelcomFrm();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
    }
}
