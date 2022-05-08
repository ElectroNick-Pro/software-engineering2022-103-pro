package com.group2022103.flightkiosk.view;

public class SeatChoice {
	private boolean upgrade;
	private int ticketId;
	private int intervalId;
	private int seatId;
	private int columnNo;
	private int rowNo;
	private String seatNo;
	private String seatClass;
	private Double price;
	private String type;
	
	public SeatChoice(int intervalId, int ticketId, int seatId, int columnNo, int rowNo, String seatNo, String seatClass, Double price, String type, boolean upgrade) {
		//parameter outside the Seat model
		this.upgrade = upgrade;
		//all parameters in Seat model
		this.intervalId = intervalId;
		this.ticketId = ticketId; 
		this.seatId = seatId;
		this.columnNo = columnNo;
		this.rowNo = rowNo;
		this.seatNo = seatNo;
		this.seatClass = seatClass;
		this.price = price;
		this.type = type;
	}


	public int getColumnNo() {
		return columnNo;
	}


	public int getRowNo() {
		return rowNo;
	}


	public boolean isUpgrade() {
		return upgrade;
	}

	public int getTicketId() {
		return ticketId;
	}

	public int getIntervalId() {
		return intervalId;
	}

	public int getSeatId() {
		return seatId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public Double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}
}
