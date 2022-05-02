package com.group2022103.flightkiosk.mapper.base;

import java.util.*;

public interface Mapper<T> {
	public T getById(Integer id);
	public List<T> queryAll();
	public T update(T obj);
}
