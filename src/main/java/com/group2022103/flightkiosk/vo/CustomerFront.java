package com.group2022103.flightkiosk.vo;

import com.group2022103.flightkiosk.model.Customer;

public class CustomerFront {
    private Customer customer;

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }
}
