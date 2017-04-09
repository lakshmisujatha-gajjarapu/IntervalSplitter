package com.submission.intervalSplitter.actions;

import java.util.ArrayList;

import com.submission.intervalSplitter.model.IntervalObject;
import com.submission.intervalSplitter.model.IntervalOverlapPoint;

public class IntervalExclude {
	
	public static ArrayList<IntervalObject> removeExcludes(ArrayList<IntervalOverlapPoint> intervalOverlapPoint) {
		ArrayList<IntervalObject> result = new ArrayList<>();

		int one = 1;
		boolean start = false; 
		boolean split = false; 
		int intervalStart = 0;
		for (IntervalOverlapPoint point : intervalOverlapPoint) {
			switch (point.overlapmode) {
			case IncludeIntervalStart:
				if (!split) {
					intervalStart = point.value;

				}
				start = true;
				break;
			case IncludeIntervalEnd:
				if (!split) {
					result.add(new IntervalObject(intervalStart, point.value));

				}
				start = false;
				break;
			case ExcludeIntervalStart:
				if (start) {
					if (intervalStart < point.value) {
						result.add(new IntervalObject(intervalStart, point.value - one));
					}
				}
				split = true;
				break;
			case ExcludeIntervalEnd:
				if (start) {
					intervalStart = point.value + one;

				}
				split = false;
				break;
			}
		}

		return result;
	}



}
