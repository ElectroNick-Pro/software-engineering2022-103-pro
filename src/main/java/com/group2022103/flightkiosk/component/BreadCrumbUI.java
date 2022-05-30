package com.group2022103.flightkiosk.component;

import java.awt.*;
import java.nio.file.Path;
import java.util.LinkedList;

import javax.swing.*;

public class BreadCrumbUI extends JPanel{
    private LinkedList<HrefButtonUI> crumbs = new LinkedList<>();
    private Path currentPath = null;
    private Path totalPath = Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay");
    public BreadCrumbUI(Path path){
        super();
        setBackground(Color.WHITE);

        if(currentPath == null){
            currentPath = path;
            if(path.getNameCount() > currentPath.getNameCount()){
                currentPath = path;
            }
        }
        int n = totalPath.getNameCount();
        int k = currentPath.getNameCount();
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
}
