package com.group2022103.flightkiosk.view;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.group2022103.flightkiosk.model.Airline;
import com.group2022103.flightkiosk.model.Flight;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.model.Ticket;

public class FlightInfoView {
	private String BookingID, date, airline,flightNo;
	private String departPlace,arrivePlace;
	private String departureAirport,arriveAirport;
	private String departureTime,arriveTime;
	private String lastTime;
	private String seatClass;
	private String foodType;
	private String terminalNo,gateNo;
	private String userName, userID;
	private int ticketID,flightID,intervalID;

	public FlightInfoView(Ticket ticket,Flight flight,Plane plane,Interval interval/*,Airline airline*/) {
		Date departDt = interval.getDepartureTime();
		Date destDt = interval.getDestTime();
		this.setLastTime(this.lastTimeFormat(departDt, destDt));
		this.setBookingID(ticket.getBookingId());
		this.setDate(this.setDateFormat(departDt));
//		this.setAirline(airline.getName());
		this.setFlightNo(flight.getFlightNo());
		this.setDepartureTime(this.setTimeFormat(departDt));
		this.setArriveTime(this.setTimeFormat(destDt)); 
		this.setDepartPlace(interval.getDepartureCity());
		this.setArrivePlace(interval.getDestCity());
		this.setDepartureAirport(interval.getDepartureAirport());
		this.setArriveAirport(interval.getDestAirport());
		this.setSeatClass(ticket.getSeatClass());
		this.setFoodType("Food Provided");
		this.setTerminalNo(interval.getTerminal());
		this.setGateNo(interval.getGate());
		this.setIntervalID(interval.getId());
		this.setTicketID(ticket.getId());
		this.setFlightID(flight.getId());
		if(this.isCheckIn(ticket.getIsCheckin())) {
			//TODO
		};
	}
	public String lastTimeFormat(Date departDt, Date destDt) {
		var timeDelta = Duration.between(departDt.toInstant(), destDt.toInstant());
		String lastTimeStr = "" + timeDelta.toHours() + "h" + timeDelta.toMinutes() % 60 + "min";
		return lastTimeStr;
	}
	public boolean isCheckIn(int checkIn) {
		if(checkIn == 0) {
			return false;
		}else {
			return true;
		}
	}
	public String setDateFormat(Date departDt) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
	    sdf = new SimpleDateFormat("MMMMM dd,yyyy",Locale.US);
	    String timeFormat = sdf.format(departDt);
	    return timeFormat;
	}
	public String setTimeFormat(Date time) {
		int hour = (int)time.getHours();
		int minute = (int)time.getMinutes();
		String timeFormat = "";
		if(minute == 0) {
			timeFormat = hour+":"+minute+"0";
		}else {
			timeFormat = hour+":"+minute;
		}
		return timeFormat;
	}
	public String getBookingID() {
		return BookingID;
	}
	public void setBookingID(String bookingID) {
		BookingID = bookingID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepartPlace() {
		return departPlace;
	}
	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}
	public String getArrivePlace() {
		return arrivePlace;
	}
	public void setArrivePlace(String arrivePlace) {
		this.arrivePlace = arrivePlace;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}
	public String getArriveAirport() {
		return arriveAirport;
	}
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getTerminalNo() {
		return terminalNo;
	}
	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}
	public String getGateNo() {
		return gateNo;
	}
	public void setGateNo(String gateNo) {
		this.gateNo = gateNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public int getIntervalID() {
		return intervalID;
	}
	public void setIntervalID(int intervalID) {
		this.intervalID = intervalID;
	}
	
	
	
}
