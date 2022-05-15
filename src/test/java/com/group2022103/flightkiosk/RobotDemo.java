package com.group2022103.flightkiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.page.*;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Robot;

public class RobotDemo{

public static void RobotRun(Robot robot){
    robot.delay(1000);
    System.out.println("Robot start");
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
        Application.run();
    Robot robot=new Robot();
    RobotRun(robot);
}
    catch(AWTException e){

    }
}

}