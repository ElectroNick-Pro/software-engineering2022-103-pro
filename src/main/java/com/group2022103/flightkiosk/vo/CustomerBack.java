package com.group2022103.flightkiosk.vo;

public class CustomerBack {
    private String customerID;
	private int id;
	private String bookingID;
	public void setBookingID(String bookingID){
		this.bookingID = bookingID;
	}
	public String getBookingID(){
		return bookingID;
	}
	public int getID(){
		return id;
	}
	public void setID(int id){
		this.id = id;
	}
    public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}	
}
