package com.submission.intervalSplitter.actions;

import java.util.ArrayList;
import java.util.Collections;

import com.submission.intervalSplitter.model.IntervalObject;
import com.submission.intervalSplitter.model.IntervalOverlapPoint;
import com.submission.intervalSplitter.model.IntervalOverlapPoint.OverlapMode;


public class IntervalSplit {
	
	public static ArrayList<IntervalObject> split(ArrayList<IntervalObject> includeIntervalRanges, ArrayList<IntervalObject> excludeIntervalRanges){
		
		//Merge all the inputIncludeIntervals to a single include Interval
		includeIntervalRanges = IntervalMerger.merge(includeIntervalRanges);
		
		//Merge all the inputExcludeIntervals (if any) to a single exclude Interval
		excludeIntervalRanges = IntervalMerger.merge(excludeIntervalRanges);

		ArrayList<IntervalOverlapPoint> inputintervals = intervalOverlapPoints(includeIntervalRanges,excludeIntervalRanges);
		ArrayList<IntervalObject> resultInterval = new ArrayList<IntervalObject>();
		if(excludeIntervalRanges.size()>0){
			resultInterval = IntervalExclude.removeExcludes(inputintervals);
		}
		else{
			resultInterval = includeIntervalRanges;
		}
		return resultInterval;
	}
	

	private static ArrayList<IntervalOverlapPoint> intervalOverlapPoints(
			ArrayList<IntervalObject> includeIntervalRanges, ArrayList<IntervalObject> excludeIntervalRanges) {
		// TODO Auto-generated method stub
		ArrayList<IntervalOverlapPoint> intervalOverlapPoint = new ArrayList<>();
		for (IntervalObject interval : includeIntervalRanges) {
			intervalOverlapPoint
					.add(new IntervalOverlapPoint(interval.getIntervalStart(), OverlapMode.IncludeIntervalStart));
			intervalOverlapPoint
					.add(new IntervalOverlapPoint(interval.getIntervalEnd(), OverlapMode.IncludeIntervalEnd));
		}
		for (IntervalObject interval : excludeIntervalRanges) {
			intervalOverlapPoint
					.add(new IntervalOverlapPoint(interval.getIntervalStart(), OverlapMode.ExcludeIntervalStart));
			intervalOverlapPoint
					.add(new IntervalOverlapPoint(interval.getIntervalEnd(), OverlapMode.ExcludeIntervalEnd));
		}

		Collections.sort(intervalOverlapPoint);
		return intervalOverlapPoint;
	}

}


