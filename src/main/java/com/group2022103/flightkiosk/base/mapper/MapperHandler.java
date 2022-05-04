package com.group2022103.flightkiosk.base.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperHandler implements InvocationHandler {
	
	private Object target;
	
	public MapperHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(target, args);
	}

}
