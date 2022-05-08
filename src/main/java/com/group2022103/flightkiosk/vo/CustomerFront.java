package com.group2022103.flightkiosk.vo;

public class CustomerFront {
    private String creditId;
    private String password;
    private String surname;
    
    public String getCreditID(){
        return creditId;
    }

    public String getPassword(){
        return password;
    }
    
    public void setCreditID(String creditId){
        this.creditId = creditId;
    } 
    
    public void setPassword(String password){
        this.password = password;
    }

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

}
