package com.group2022103.flightkiosk.util;

public class FieldUtil {
	
	private static String toInitCap(String str) {
		return "" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}
	
	public static String toModifier(String fieldName) {
		return "set" + toInitCap(fieldName);
	}
	
	public static String toAccessor(String fieldName) {
		return "get" + toInitCap(fieldName);
	}

}
