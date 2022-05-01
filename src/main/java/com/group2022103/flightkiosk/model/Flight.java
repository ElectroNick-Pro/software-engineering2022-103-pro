package com.group2022103.flightkiosk.model;

public class Flight {
	
	private Integer id;
	
	private Integer plane;
	private String flightNo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPlane() {
		return plane;
	}
	public void setPlane(Integer plane) {
		this.plane = plane;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
}
