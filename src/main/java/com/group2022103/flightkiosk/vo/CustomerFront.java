package com.group2022103.flightkiosk.vo;

import com.group2022103.flightkiosk.model.Customer;

public class CustomerFront {
    private int ID;
    private String customerId;
    private String surname;
    private String firstname;
    private String creditId;
    private String password;

    public String getCustomerID(){
        return customerId;
    }
    
    public String getCreditID(){
        return creditId;
    }

    public String getPassword(){
        return password;
    }

	public String getSurname() {
		return surname;
	}

	public String getFirstName(){
        return firstname;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setCreditID(String creditId){
        this.creditId = creditId;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setCustomerID(String customerId){
        this.customerId = customerId;
    }

}
