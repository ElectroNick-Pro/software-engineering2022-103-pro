package com.group2022103.flightkiosk.base.mapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.exception.ObjectNotFoundException;
import com.group2022103.flightkiosk.util.CsvUtil;
import com.group2022103.flightkiosk.util.FieldUtil;

public class MapperImpl<T> implements Mapper<T> {
	
	private Class<T> clz;
	
	private Path storagePath;
	
	public Path getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(Path storagePath) {
		this.storagePath = storagePath;
	}
	
	public Class<T> getClz() {
		return clz;
	}
	
	public void setClz(Class<T> clz) {
		this.clz = clz;
	}
	
	

	@Override
	public T getById(Integer id) {
		try {
			T res = clz.getConstructor().newInstance();
			var lines = Files.readAllLines(storagePath, StandardCharsets.UTF_8);
			if(id >= lines.size()) {
				throw new ObjectNotFoundException();
			}
			var keys = CsvUtil.splitLine(lines.get(0));
			var vals = CsvUtil.splitLine(lines.get(id));
			int n = keys.length;
			for(int i = 0; i < n; i++) {
				var fieldClz = clz.getDeclaredField(keys[i]).getType();
				var modifier = clz.getMethod(FieldUtil.toModifier(keys[i]), fieldClz);
				modifier.invoke(res, Application.context.getCsvConfig().getParseMethodMap().get(fieldClz).apply(vals[i]));
			}
			return res;
		} catch (IOException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException 
				| NoSuchMethodException | SecurityException | ObjectNotFoundException 
				| NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> queryAll() {
		try {
			var ret = new ArrayList<T>();
			var lines = Files.readAllLines(storagePath, StandardCharsets.UTF_8);
			var keys = CsvUtil.splitLine(lines.get(0));
			int n = keys.length;
			for(var ln: lines.subList(1,lines.size())) {
				if(ln == null || "".equals(ln)) {
					continue;
				}
				var vals = CsvUtil.splitLine(ln);
				T obj = clz.getConstructor().newInstance();
				for(int i = 0; i < n; i++) {
					var fieldClz = clz.getDeclaredField(keys[i]).getType();
					var modifier = clz.getMethod(FieldUtil.toModifier(keys[i]), fieldClz);
					modifier.invoke(obj, Application.context.getCsvConfig().getParseMethodMap().get(fieldClz).apply(vals[i]));
				}
				ret.add(obj);
			}
			return ret;
		} catch (IOException | InstantiationException | IllegalAccessException 
				| IllegalArgumentException | InvocationTargetException 
				| NoSuchMethodException | SecurityException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public T update(T obj) {
		try {
			var lines = Files.readAllLines(storagePath, StandardCharsets.UTF_8);
			var keys = CsvUtil.splitLine(lines.get(0));
			var id = (Integer)clz.getMethod(FieldUtil.toAccessor("id")).invoke(obj);
			if(id == null || id >= lines.size()) {
				clz.getMethod(FieldUtil.toModifier("id"), Integer.class).invoke(obj, lines.size());
			}
			var row = new LinkedList<String>();
			for(var key: keys) {
				var fieldClz = clz.getDeclaredField(key).getType();
				var value = clz.getMethod(FieldUtil.toAccessor(key)).invoke(obj);
				row.add(Application.context.getCsvConfig().getToStringMap().get(fieldClz).apply(value));
			}
			var rowStr = row.stream().reduce((a,b)->a+","+b).get();
			if(id == null || id >= lines.size()) {
				lines.add(rowStr);
			} else {
				lines.set(id, rowStr);
			}
			Files.write(storagePath, lines);
			return obj;
		} catch (IOException | IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException | NoSuchMethodException 
				| SecurityException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> MapperImpl<T> of(Class<T> clz) {
		var ret = new MapperImpl<T>();
		ret.setClz(clz);
		return ret;
	}

}
