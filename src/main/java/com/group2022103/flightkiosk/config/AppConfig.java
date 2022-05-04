package com.group2022103.flightkiosk.config;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class AppConfig {
	
	private SimpleDateFormat timezone;
	
	public AppConfig() {
		
		timezone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timezone.setTimeZone(TimeZone.getTimeZone("UTC"));
		
	}

	public SimpleDateFormat getTimezone() {
		return timezone;
	}

}
