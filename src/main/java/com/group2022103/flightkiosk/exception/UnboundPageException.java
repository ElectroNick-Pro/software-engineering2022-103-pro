package com.group2022103.flightkiosk.exception;

public class UnboundPageException extends Exception {
	public UnboundPageException() {
		super("Page not bound");
	}
}
