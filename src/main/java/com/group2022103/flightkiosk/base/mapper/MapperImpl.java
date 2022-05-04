package com.group2022103.flightkiosk.base.mapper;

import java.nio.file.Path;
import java.util.*;

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
	
	private String[] splitLine(String str) {
        if(str.endsWith(",")) {
            str += ",-";
            var res = str.split(",");
            return Arrays.copyOf(res, res.length - 1);
        } else {
            return str.split(",");
        }
    }

	@Override
	public T getById(Integer id) {
		
		return null;
	}

	@Override
	public List<T> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static <T> MapperImpl<T> of(Class<T> clz) {
		var ret = new MapperImpl<T>();
		ret.setClz(clz);
		return ret;
	}

}
