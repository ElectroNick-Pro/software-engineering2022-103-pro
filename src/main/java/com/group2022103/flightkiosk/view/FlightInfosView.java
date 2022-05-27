package com.group2022103.flightkiosk.view;

import java.util.*;

import javax.swing.table.AbstractTableModel;

import com.group2022103.flightkiosk.controller.FlightController;
import com.group2022103.flightkiosk.controller.FlightInfosController;
import com.group2022103.flightkiosk.vo.FlightBack;
import com.group2022103.flightkiosk.vo.FlightInfosBack;
import com.group2022103.flightkiosk.vo.FlightInfosFront;

public class FlightInfosView extends AbstractTableModel {

    private final static String[] colNames = {"Flight id", "Ticket id", "Check-in", "Customer name", "Customer id"};

    private final static List<Class<?>> colClzList = List.of(
        String.class,
        String.class,
        String.class,
        String.class,
        String.class
    );

    private List<List<Object>> ticketList = new ArrayList<>();

    private FlightInfosFront flightInfosFront;

    protected FlightInfosView() {}

    public FlightInfosView(FlightInfosBack flightInfosBack) {
        flightInfosFront = new FlightInfosController().get(flightInfosBack);
        var flightIds = new ArrayList<String>();
        flightInfosFront.getTicketMap().forEach((k1,v1)-> {
            v1.forEach((k2,v2)->{
                var customer = flightInfosFront.getCustomerMap().get(k1).get(k2);
                flightIds.add(k1.toString());
                List<Object> ls = new ArrayList<Object>();
                ls.add(k1);
                ls.add(v2.getBookingId());
                ls.add(v2.getIsCheckin().equals(1) ? "Checked-in" : "Not Checked-in");
                ls.add(customer.getFullName());
                ls.add(customer.getCustomerId());
                ticketList.add(ls);
            });
        });
        var flightNums = new FlightController().get(new FlightBack(){{setFlightID(flightIds);}}).getFlights();
        int n = ticketList.size();
        for(int i = 0; i < n; i++) {
            ticketList.get(i).set(0, flightNums.get(Integer.parseInt(flightIds.get(i))).getFlightNo());
        }
        ticketList.sort((x,y)->{
            return ((String)x.get(1)).compareTo((String)y.get(1));
        });
    }
    @Override
    public int getRowCount() {
        return ticketList.size();
    }
    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ticketList.get(rowIndex).get(columnIndex);
    }
    @Override
    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return colClzList.get(columnIndex);
    }
}
