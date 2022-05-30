package com.group2022103.flightkiosk.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AppConfig {
	
	private SimpleDateFormat timezone;
	private Date curTime;
	private MessageDigest digest;
	
	public AppConfig() {
		
		timezone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timezone.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		try {
			curTime = timezone.parse("2022-04-06 12:00:00");
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException | ParseException e) {
			e.printStackTrace();
		}
	}

	public SimpleDateFormat getTimezone() {
		return timezone;
	}

	public Date getCurTime() {
		return curTime;
	}

	public MessageDigest getDigest() {
		return digest;
	}

}
