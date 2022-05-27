package com.group2022103.flightkiosk.view;

import java.util.*;

import com.group2022103.flightkiosk.controller.IntervalController;
import com.group2022103.flightkiosk.model.Interval;
import com.group2022103.flightkiosk.vo.IntervalBack;
import com.group2022103.flightkiosk.vo.IntervalFront;

public class IntervalView {
	private IntervalFront intervalFront;

	protected IntervalView() {}

	public IntervalView(IntervalBack intervalBack) {
		intervalFront = new IntervalController().get(intervalBack);
	}

	public Interval getInterval(int flightID) {
		Map<Integer,List<Interval>> intervals = intervalFront.getIntervals();
		Interval interval = intervals.get(flightID).get(0);
		return interval;
	}

	public Map<Integer, List<Interval>> getAllIntervals() {
		return intervalFront.getIntervals();
	}
}
