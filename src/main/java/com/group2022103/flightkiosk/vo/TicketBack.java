package com.group2022103.flightkiosk.vo;

public class TicketBack {
	private String surname;
	private String documentID;
	private String bookingID;
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}	
	public String getBookingID(){
		return bookingID;
	}
	public void setBookingID(String bookingID){
		this.bookingID = bookingID;
	}
}
