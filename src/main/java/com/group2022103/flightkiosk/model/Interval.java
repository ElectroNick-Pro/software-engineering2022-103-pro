package com.group2022103.flightkiosk.model;

import java.util.Date;

public class Interval {
	private Integer id;
	private Integer flight;
	private String departureCity;
	private String departureAirport;
	private String destCity;
	private String destAirport;
	private Date departureTime;
	private Date destTime;
	private String gate;
	private String terminal;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFlight() {
		return flight;
	}
	public void setFlight(Integer flight) {
		this.flight = flight;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	public String getDestAirport() {
		return destAirport;
	}
	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getDestTime() {
		return destTime;
	}
	public void setDestTime(Date destTime) {
		this.destTime = destTime;
	}
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
}
