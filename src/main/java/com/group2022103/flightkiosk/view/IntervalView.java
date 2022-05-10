package com.group2022103.flightkiosk.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.model.Plane;
import com.group2022103.flightkiosk.vo.IntervalBack;
import com.group2022103.flightkiosk.vo.IntervalFront;
import com.group2022103.flightkiosk.vo.PlaneFront;

public class IntervalView {
	private IntervalFront intervalFront;
	public IntervalView(IntervalBack intervalBack) {
		var map = new HashMap<Integer,List<Interval>>();
		intervalFront = new IntervalFront();
		this.intervalFront.setIntervals(map);
		/*Bypass backend ends*/
		// setIntervalFront(new IntervalController().getInterval(intervalBack));
	}
	public IntervalFront getIntervalFront() {
		return intervalFront;
	}
	public void setIntervalFront(IntervalFront intervalFront) {
		this.intervalFront = intervalFront;
	}
	public Interval getInterval(int flightID) {
		Map<Integer,List<Interval>> intervals = this.getIntervalFront().getIntervals();
		Interval interval = intervals.get(flightID).get(0);
		return interval;
	}
}
