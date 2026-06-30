package com.javaweb.utils;

import java.util.List;
import java.util.Objects;

public class StringUtil {
	public static boolean stringValid(String data) {
		if(data != null && !data.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean stringListValid(List<String> data) {
		if(data != null && !data.isEmpty() // Kiem tra list ko null, ko rong
				&& data.stream().noneMatch(Objects::isNull)) // Kiem tra list ko co phan tu rong
		{
			return true;
		}
		return false;
	}
}
