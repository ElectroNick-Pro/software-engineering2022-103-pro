package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.controller.CustomerController;
import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.util.CsvUtil;
import com.group2022103.flightkiosk.vo.*;

public class CustomerView {
    private CustomerFront customerFront;
    // the data passed by the user
    public CustomerView(CustomerBack customerBack){
        // customerFront = new CustomerFront();
        // customerFront.setCreditID("4001234567");
        // customerFront.setPassword("123123123");
        // customerFront.setSurname("surname");
        // there is no method called "getCustomer()" in CustomerController
        setCustomerFront(new CustomerController().get(customerBack));
    }

    public void setCustomerFront(CustomerFront customerFront){
        this.customerFront = customerFront;
    }

    public CustomerFront getCustomerFront(){
        return customerFront;
    }

    public boolean isValid(String creditId,String password){
        System.out.println(customerFront.getCustomer().getCreditId() + " " + customerFront.getCustomer().getPassword());
        if(customerFront.getCustomer().getCreditId().equals(creditId) && CsvUtil.toMD5(password).equals(customerFront.getCustomer().getPassword())){
            return true;
        }
        else{
            return false;
        }
    }

    public Customer getCustomer(){
        return customerFront.getCustomer();
    }
}
