package com.group2022103.flightkiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group2022103.flightkiosk.application.Application;

import java.awt.Robot;

public class RobotDemo{

public static void RobotRun(Robot robot){
    //JOptionPane.showMessageDialog(null, "The demo is going to start,if any anomaly occurs,may the type of your screen matters,please turn to manual operation", "Caution!", JOptionPane.WARNING_MESSAGE);
    System.out.println("Robot start...");
    robot.delay(2000);
    robot.mouseMove(861,712);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(990,770);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(810,710);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(640,640);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(620,450);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(1250,730);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(525,450);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(1250,730);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(730,500);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(1250,730);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(600,540);
    for(int i=0;i<3;i++){
    robot.delay(500);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    robot.delay(1000);
    robot.mouseMove(1250,730);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(700,560);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(1100,230);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(500);
    robot.mouseMove(1250,730);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(850,650);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(500);
    robot.mouseMove(1000,650);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(1000);
    robot.mouseMove(620,680);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(5000);
    JOptionPane.showMessageDialog(null, "Demo completed...", "Finish", JOptionPane.PLAIN_MESSAGE);
    System.out.println("Demo complete...");
    
}

public  static void main(String[] args){
    
    //Application.run();
    /*JFrame demo=new JFrame();
    demo.setSize(1920,1080);
    demo.setVisible(true);
    JButton d=new JButton("DD");
    d.setSize(1920,1080);
    demo.add(d);*/
    /*WelcomeFrm w=new WelcomeFrm();
    w.setVisible(true);
    w.setLocationRelativeTo(null);*/
    try{
        JOptionPane.showMessageDialog(null, "The demo is going to start,if any anomaly occurs,may the type of your screen matters,please turn to manual operation", "Caution!", JOptionPane.WARNING_MESSAGE);
        Application.run();
    Robot robot=new Robot();
    RobotRun(robot);
}
    catch(AWTException e){

    }
}

}