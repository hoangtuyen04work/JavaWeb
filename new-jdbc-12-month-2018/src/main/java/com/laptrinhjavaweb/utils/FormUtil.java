package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> clazz, HttpServletRequest req) {
		T object = null;
		
		try {
			object = (T) clazz.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		
		return object;
	}
}
