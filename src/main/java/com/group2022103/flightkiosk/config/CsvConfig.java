package com.group2022103.flightkiosk.config;

import java.text.ParseException;
import java.util.*;
import java.util.function.Function;

import com.group2022103.flightkiosk.application.Application;

public class CsvConfig {
	
	private Map<Class<?>, Function<String, Object>> parseMethodMap = new HashMap<>();
	private Map<Class<?>, Function<Object, String>> toStringMap = new HashMap<>();

	public CsvConfig () {
		parseMethodMap.put(Integer.class, (s)-> {
			return s.equals("") ? null : Integer.parseInt(s);
		});
		
		toStringMap.put(Integer.class, (obj) -> {
			return obj == null ? "" : obj.toString();
		});
		
		parseMethodMap.put(Double.class, (s)-> {
			return s.equals("") ? null : Double.parseDouble(s);
		});
		
		toStringMap.put(Double.class, (obj)-> {
			return obj == null ? "" : obj.toString();
		});
		
		parseMethodMap.put(String.class, (s)-> {
			return s;
		});
		
		toStringMap.put(String.class, (obj)->{
			return obj.toString();
		});
		
		parseMethodMap.put(Date.class, (s)-> {
			try {
				return s.equals("") ? null : Application.context.getAppConfig().getTimezone().parse(s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		
		toStringMap.put(Date.class, (obj)->{
			return obj == null ? "" : Application.context.getAppConfig().getTimezone().format((Date)obj);
		});
	}

	public Map<Class<?>, Function<String, Object>> getParseMethodMap() {
		return parseMethodMap;
	}

	public Map<Class<?>, Function<Object, String>> getToStringMap() {
		return toStringMap;
	}

}
