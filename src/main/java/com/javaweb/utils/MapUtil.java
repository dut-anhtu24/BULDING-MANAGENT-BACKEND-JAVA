package com.javaweb.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
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
	
	public static <T> T getObject(Map<String, Object> map, String key, Class<T> tClass) {
		Object obj = map.getOrDefault(key, null);
		if(obj != null) {
			if(tClass.getTypeName().equals("java.lang.Long")) {
				obj = obj != "" ? Long.valueOf(obj.toString()) : null;
			} 
			else if(tClass.getTypeName().equals("java.lang.Integer")) {
				obj = obj != "" ? Integer.valueOf(obj.toString()) : null;
			}
			else if(tClass.getTypeName().equals("java.lang.Double")) {
				obj = obj != "" ? Double.valueOf(obj.toString()) : null;
			}
			else if(tClass.getTypeName().equals("java.math.BigDecimal")) {
				obj = obj != "" ? BigDecimal.valueOf(Double.valueOf(obj.toString())) : null;
			} else {
				obj = obj.toString();
			}
			
			return tClass.cast(obj);
		}
		return null;
	}
}
