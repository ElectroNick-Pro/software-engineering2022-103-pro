package com.group2022103.flightkiosk.application;

import java.util.*;

import com.group2022103.flightkiosk.config.*;

public class ApplicationContext {
	
	private Map<String, Object> context = new HashMap<>();
	
	private Map<String, Object> cache = new HashMap<>();
	
	private AppConfig appConfig = new AppConfig();
	
	private MapperConfig mapperConfig = new MapperConfig();
	
	private CsvConfig csvConfig = new CsvConfig();
	
	private PageConfig pageConfig = new PageConfig();
	
	public Map<String, Object> getContext() {
		return context;
	}
	
	public Map<String, Object> getCache() {
		return cache;
	}

	public AppConfig getAppConfig() {
		return appConfig;
	}

	public MapperConfig getMapperConfig() {
		return mapperConfig;
	}

	public CsvConfig getCsvConfig() {
		return csvConfig;
	}

	public PageConfig getPageConfig() {
		return pageConfig;
	}
}
