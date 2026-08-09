package com.javaweb.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringUtil {
	public static boolean stringValid(String data) {
		if(data != null && !data.trim().isEmpty()) {
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
	
	public static List<String> stringNormalList(List<String> list) {
		if (StringUtil.stringListValid(list)) {
			if (list.size() == 1) {
				list = Arrays.asList(list.get(0).split("-"));
			}
		}
		return list;
	}
}
