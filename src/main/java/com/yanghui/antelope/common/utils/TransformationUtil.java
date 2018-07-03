package com.yanghui.antelope.common.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.StringUtils;

public class TransformationUtil {
	
	public static <T> Map<String,Object> toMap(T t) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		Field[] fs = t.getClass().getDeclaredFields();
		for(Field f : fs){
			f.setAccessible(true);
			Object o = f.get(t);
			if(o != null){
				result.put(f.getName(),o);
			}
			f.setAccessible(false);
		}
		return result;
	}
	
	public static <T> T toObject(Map<String,Object> map,Class<T> clz) throws Exception{
		T t = clz.newInstance();
		for(Entry<String,Object> entry : map.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			Field f = null;
			try {
				f = clz.getDeclaredField(key);
			} catch (Exception e) {
				continue;
			}
			if(f == null)continue;
			if(StringUtils.isEmpty(value)){
				continue;
			}
			String type = f.getType().toString();
			f.setAccessible(true);
			if(type.endsWith("Date")){
				f.set(t,DateUtil.parse(value.toString(), "yyyy-MM-dd"));
			}else if(type.endsWith("int") || type.endsWith("Integer")){
				f.set(t, Integer.valueOf(value.toString()));
			}else if(type.endsWith("Long") || type.endsWith("long")){
				f.set(t, Long.valueOf(value.toString()));
			}else if(type.endsWith("String")){
				f.set(t,value.toString());
			}else if(type.endsWith("BigDecimal")){
				f.set(t, new BigDecimal(value.toString()));
			}
			f.setAccessible(false);
		}
		return t;
	}
}
