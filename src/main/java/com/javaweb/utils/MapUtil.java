package com.javaweb.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapUtil {
	public static Map<String, Object> toMap(Object list) {
		Map<String, Object> result = new LinkedHashMap<>();
		Field[] fields = list.getClass().getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true); // Cho phep truy cap private
			try {
				result.put(field.getName(), field.get(list));
			} catch(IllegalAccessException e)  {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
