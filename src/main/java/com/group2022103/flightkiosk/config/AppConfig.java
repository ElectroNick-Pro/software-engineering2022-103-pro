package com.group2022103.flightkiosk.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class AppConfig {
	
	private SimpleDateFormat timezone;
	private MessageDigest digest;
	
	public AppConfig() {
		
		timezone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timezone.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public SimpleDateFormat getTimezone() {
		return timezone;
	}

	public MessageDigest getDigest() {
		return digest;
	}

}
