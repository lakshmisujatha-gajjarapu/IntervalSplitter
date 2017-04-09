package com.submission.intervalSplitter.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.submission.intervalSplitter.model.IntervalObject;

public class IntervalMerger {

	@SuppressWarnings("unchecked")
	public static ArrayList<IntervalObject> merge(ArrayList<IntervalObject> intervalRanges) {
		// TODO Auto-generated method stub
		if (intervalRanges.size() <= 1)
			return intervalRanges;
		Collections.sort(intervalRanges, new Comparator<IntervalObject>(){
			@Override
			public int compare(IntervalObject o1,IntervalObject o2){
				//TODO Auto-generated method stub
				return o1.getIntervalStart() - o2.getIntervalStart();
			}
		});

		IntervalObject comparisonBaseline = intervalRanges.get(0);
		int baselineIntervalStart = comparisonBaseline.getIntervalStart();
		int baselineIntervalEnd = comparisonBaseline.getIntervalEnd();

		ArrayList<IntervalObject> mergedInterval = new ArrayList<IntervalObject>();

		for (int i = 1; i < intervalRanges.size(); i++) {
			IntervalObject currentPointer = intervalRanges.get(i);
			if (currentPointer.getIntervalStart() <= baselineIntervalEnd) {
				baselineIntervalEnd = Math.max(currentPointer.getIntervalEnd(), baselineIntervalEnd);
			} else {
				mergedInterval.add(new IntervalObject(baselineIntervalStart, baselineIntervalEnd));
				baselineIntervalStart = currentPointer.getIntervalStart();
				baselineIntervalEnd = currentPointer.getIntervalEnd();
			}

		}

		mergedInterval.add(new IntervalObject(baselineIntervalStart, baselineIntervalEnd));

		return mergedInterval;

	}

}