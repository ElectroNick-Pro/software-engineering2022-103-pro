package com.group2022103.flightkiosk.model;

public class Plane {
	private Integer id;
	private Integer airline;
	private Integer columnLength;
	private Integer rowLength;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAirline() {
		return airline;
	}
	public void setAirline(Integer airline) {
		this.airline = airline;
	}
	public Integer getColumnLength() {
		return columnLength;
	}
	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}
	public Integer getRowLength() {
		return rowLength;
	}
	public void setRowLength(Integer rowLength) {
		this.rowLength = rowLength;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
