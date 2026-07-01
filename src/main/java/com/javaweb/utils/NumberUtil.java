package com.javaweb.utils;

public class NumberUtil {
	public static boolean allNotNull(Number...numbers) {
		for(Number number : numbers) {
			if(number == null)
				return false;
		}
		
		return true;
	}
	
	public static boolean anyNotNull(Number...numbers) {
		for(Number number : numbers) {
			if(number != null)
				return true;
		}
		
		return false;
	}
	
	public static boolean isNumber(String value) {
		try {
			Long number = Long.parseLong(value);
		} catch(NumberFormatException ex) {
			System.out.print(value + " is not number!\n");
			return false;
		}
		return true;
	}
	
	public static boolean isNumber(Object value) {
		return value instanceof Number;
	}
}
