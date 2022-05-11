package com.group2022103.flightkiosk.view;

import com.group2022103.flightkiosk.controller.CustomerController;
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

    public boolean isValid(String creditId,String password){
        System.out.println(customerFront.getCreditID() + " " + customerFront.getPassword());
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

    public String getCustomerID(){
        return customerFront.getCustomerID();
    }
    
    public String getCreditID(){
        return customerFront.getCreditID();
    }

    public String getPassword(){
        return customerFront.getPassword();
    }

	public String getFirstName(){
        return customerFront.getFirstName();
    }

    public int getID(){
        return customerFront.getID();
    }
}
