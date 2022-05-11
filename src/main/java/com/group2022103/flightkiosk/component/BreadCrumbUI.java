package com.group2022103.flightkiosk.component;

import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.LinkedList;

import javax.swing.*;

import com.group2022103.flightkiosk.application.Application;

public class BreadCrumbUI extends JPanel{
    private Path path;
    private LinkedList<HrefButtonUI> crumbs = new LinkedList<>();
    private Path totalPath = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay");
    public BreadCrumbUI(Path path){
        super();
        setBackground(Color.WHITE);
        // System.out.println(Application.context.getContext().get("curPath"));

        int n = totalPath.getNameCount();
        int k = path.getNameCount();
        for(int i = 1;i <= n;i++){
            HrefButtonUI btn = new HrefButtonUI(Path.of("/").resolve(totalPath.subpath(0, i)));
            JLabel label = new JLabel(">");
            add(btn);
            if(k > n || i > k){
                btn.setEnabled(false);
                label.setForeground(Color.GRAY);
                if(i < n){
                    this.add(label);
                }
            }
            else if(i < n) {
                label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
                this.add(label);
            }
            crumbs.add(btn);
        }
    }

    public LinkedList<HrefButtonUI> getBtnList(){
        return crumbs;
    }

    public static void main(String[] args) {
        var panel = new BreadCrumbUI(Path.of("/Retrieve/Flight Information/Choose Seat"));
        var frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
