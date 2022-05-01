package com.group2022103.flightkiosk.mapper.base;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class MapperImpl<T> implements Mapper<T> {
	
	private Path storagePath;
	
	public Path getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(Path storagePath) {
		this.storagePath = storagePath;
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
	public Stream<T> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
