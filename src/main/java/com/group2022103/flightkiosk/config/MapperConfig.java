package com.group2022103.flightkiosk.config;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import javax.swing.JOptionPane;

import com.group2022103.flightkiosk.base.mapper.MapperHandler;
import com.group2022103.flightkiosk.base.mapper.MapperImpl;
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
			JOptionPane.showMessageDialog(
				null, 
				"Data files are now in directory " + dataDir.toAbsolutePath().toString(), 
				"File Ready", 
				JOptionPane.PLAIN_MESSAGE
			);
		}
		
		try {
			var mapperList = ClassUtil.getClassesInPackage(mapperPackage);
			for(var mapperClz: mapperList) {
				var o = ((ParameterizedType)mapperClz.getGenericInterfaces()[0]).getActualTypeArguments()[0];
				var modelClz = Class.forName(o.getTypeName());
				var obj = MapperImpl.of(modelClz);
				var storagePath = dataDir.resolve(((Class)o).getSimpleName() + ".csv");
				
				// File generation
				if(!storagePath.toFile().exists()) {
					var srcStream = ClassLoader.getSystemResourceAsStream("data/"+((Class)o).getSimpleName() + ".csv");
					if(srcStream == null) {
						var firstRow = new ArrayList<String>();
						for(var field: modelClz.getDeclaredFields()) {
							firstRow.add(field.getName());
						}
						firstRow.sort((x,y)->{
							if("id".equals(x)) {
								return "".compareTo(y);
							} else if ("id".equals(y)) {
								return x.compareTo("");
							} else {
								return x.compareTo(y);
							}
						});
						var firstStr = firstRow.stream().reduce((a,b)->a+","+b).get();
						Files.createFile(storagePath);
						Files.write(storagePath, List.of(firstStr));
					} else {
						Files.copy(srcStream, storagePath);
					}
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

}
