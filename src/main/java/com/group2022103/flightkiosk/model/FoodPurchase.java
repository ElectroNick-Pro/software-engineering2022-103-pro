package com.group2022103.flightkiosk.model;

public class FoodPurchase {
	private Integer id;
	private Double price;
	private String name;
	private String type;
	private Integer flight;
	private String image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getFlight() {
		return flight;
	}
	public void setFlight(Integer flight) {
		this.flight = flight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
