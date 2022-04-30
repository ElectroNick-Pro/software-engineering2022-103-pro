package com.group2022103.flightkiosk.model;

public class Ticket {
	private Integer id;
	private Integer customer;
	private Integer luggageCnt;
	private String counterNo;
	private Integer flight;
	private String bookingId;
	private String seatClass;
	private Integer isCheckin;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomer() {
		return customer;
	}
	public void setCustomer(Integer customer) {
		this.customer = customer;
	}
	public Integer getLuggageCnt() {
		return luggageCnt;
	}
	public void setLuggageCnt(Integer luggageCnt) {
		this.luggageCnt = luggageCnt;
	}
	public String getCounterNo() {
		return counterNo;
	}
	public void setCounterNo(String counterNo) {
		this.counterNo = counterNo;
	}
	public Integer getFlight() {
		return flight;
	}
	public void setFlight(Integer flight) {
		this.flight = flight;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public Integer getIsCheckin() {
		return isCheckin;
	}
	public void setIsCheckin(Integer isCheckin) {
		this.isCheckin = isCheckin;
	}
}
