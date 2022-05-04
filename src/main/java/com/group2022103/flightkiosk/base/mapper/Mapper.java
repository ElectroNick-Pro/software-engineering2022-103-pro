package com.group2022103.flightkiosk.base.mapper;

import java.util.*;

public interface Mapper<T> {
	public T getById(Integer id);
	public List<T> queryAll();
	public T update(T obj);
}
