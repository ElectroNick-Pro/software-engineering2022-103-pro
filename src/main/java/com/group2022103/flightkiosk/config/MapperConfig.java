package com.group2022103.flightkiosk.config;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.*;

import com.group2022103.flightkiosk.base.mapper.MapperHandler;
import com.group2022103.flightkiosk.base.mapper.MapperImpl;
import com.group2022103.flightkiosk.mapper.*;
import com.group2022103.flightkiosk.util.ClassUtil;

public class MapperConfig {
	
	private String mapperPackage = "com.group2022103.flightkiosk.mapper";
	
	private Path dataDir = Path.of("data");
	
	private Map<Class<?>, Object> mappers = new HashMap<>();
	
	@SuppressWarnings("rawtypes")
	public MapperConfig() {
		
		var dataDirFile = dataDir.toFile();
		if(!dataDirFile.exists()) {
			if(!dataDirFile.mkdirs()) {
				System.exit(1);
			}
		}
		
		try {
			var mapperList = ClassUtil.getClassesInPackage(mapperPackage);
			for(var mapperClz: mapperList) {
				var o = ((ParameterizedType)mapperClz.getGenericInterfaces()[0]).getActualTypeArguments()[0];
				var modelClz = Class.forName(o.getTypeName());
				var obj = MapperImpl.of(modelClz);
				var storagePath = dataDir.resolve(((Class)o).getSimpleName() + ".csv");
				
				if(!storagePath.toFile().exists()) {
					var firstRow = new ArrayList<String>();
				}
				
				obj.setStoragePath(storagePath);
				var clz = obj.getClass();
				var hd = new MapperHandler(obj);
				mappers.put(mapperClz, Proxy.newProxyInstance(clz.getClassLoader(), new Class<?>[] {mapperClz}, hd));
			}
		} catch (ClassNotFoundException | IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
	}

	public Map<Class<?>, Object> getMappers() {
		return mappers;
	}
	
	public static void main(String[] args) {
		var _this = new MapperConfig();
		var am = (AirlineMapper) _this.getMappers().get(AirlineMapper.class);
		am.getById(null);
		var pm = (PlaneMapper) _this.getMappers().get(PlaneMapper.class);
		pm.getById(null);
		var cm = (CustomerMapper) _this.getMappers().get(CustomerMapper.class);
		cm.getById(null);
	}

}
