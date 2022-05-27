package com.group2022103.flightkiosk.page;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.view.FlightInfosView;
import com.group2022103.flightkiosk.vo.FlightInfosBack;

public class FlightListFrm extends JFrame {

    public FlightListFrm(FlightInfosView view) {
        add(new JScrollPane(new JTable(view)));
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        Application.run();
        var frame = new FlightListFrm(new FlightInfosView(new FlightInfosBack()));
        frame.setVisible(true);
    }

}
