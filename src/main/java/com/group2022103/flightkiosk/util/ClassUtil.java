package com.group2022103.flightkiosk.util;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.*;

public class ClassUtil {
	
	private static List<Class<?>> findFile(String packageName, Path path) throws ClassNotFoundException {
		var ret = new ArrayList<Class<?>>();
		var dir = path.toFile();
		for(var file: dir.listFiles()) {
			if(file.isDirectory()) {
				ret.addAll(findFile(packageName + "." + file.getName(), file.toPath()));
			} else if(file.getName().endsWith(".class")) {
				ret.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return ret;
	}
	
	private static List<Class<?>> findJar(String packageDir, URL url) throws IOException, ClassNotFoundException {
		var ret = new ArrayList<Class<?>>();
		var entries = ((JarURLConnection)url.openConnection()).getJarFile().entries();
		while(entries.hasMoreElements()) {
			var e = entries.nextElement();
			if(e.isDirectory()) {
				continue;
			}
			var clzPath = e.getName();
			if(clzPath.startsWith(packageDir) && clzPath.endsWith(".class")) {
				ret.add(Class.forName(clzPath.substring(0, clzPath.length() - 6).replace('/', '.')));
			}
		}
		return ret;
	}
	
	public static List<Class<?>> getClassesInPackage(String packageName) throws IOException, ClassNotFoundException, URISyntaxException {
		var ret = new ArrayList<Class<?>>();
		var packageDir = packageName.replace('.', '/');
		var url = ClassLoader.getSystemResource(packageDir);
			
		switch (url.getProtocol()) {
		case "file":
			ret.addAll(findFile(packageName, Path.of(url.toURI())));
			break;
		case "jar":
			ret.addAll(findJar(packageDir, url));
			break;
		default:
			break;
		}
		
		return ret;
	}

}
