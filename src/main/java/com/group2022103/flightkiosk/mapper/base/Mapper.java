package com.group2022103.flightkiosk.mapper.base;

import java.util.stream.Stream;

public interface Mapper<T> {
	public T getById(Integer id);
	public Stream<T> queryAll();
	public T update(T obj);
}
