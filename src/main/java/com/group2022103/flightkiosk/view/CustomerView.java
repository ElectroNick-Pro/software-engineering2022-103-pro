package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.controller.CustomerController;
import com.group2022103.flightkiosk.vo.*;

public class CustomerView {
    private CustomerFront customerFront;
    // the data passed by the user
    public CustomerView(CustomerBack customerBack){
        customerFront = new CustomerFront();
        customerFront.setCreditID("4001234567");
        customerFront.setPassword("123123123");
        customerFront.setSurname("surname");
        // there is no method called "getCustomer()" in CustomerController
        // setCustomerFront(new CustomerController().getCustomer(customerBack));
    }

    public void setCustomerFront(CustomerFront customer){
        this.customerFront = customerFront;
    }

    public boolean isValid(String creditId,String password){
        if(customerFront.getCreditID().equals(creditId) && customerFront.getPassword().equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getSurname(){
        return customerFront.getSurname();
    }
}
