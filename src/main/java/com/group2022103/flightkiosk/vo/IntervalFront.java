package com.group2022103.flightkiosk.vo;

import java.util.List;
import java.util.Map;

import com.group2022103.flightkiosk.model.Interval;

public class IntervalFront {
	// flightId-interval_list
	private Map<Integer,List<Interval>> intervals;

	public Map<Integer,List<Interval>> getIntervals() {
		return intervals;
	}

	public void setIntervals(Map<Integer,List<Interval>> intervals) {
		this.intervals = intervals;
	}
}
