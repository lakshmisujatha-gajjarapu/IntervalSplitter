package com.submission.intervalSplitter.actions;

import java.util.ArrayList;

import com.submission.intervalSplitter.model.IntervalObject;

public class IntervalAppender {

	public static String append(ArrayList<IntervalObject> splitInterval) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		for( IntervalObject intervalObject : splitInterval){
			stringBuilder.append(intervalObject.getIntervalStart() + "-" + intervalObject.getIntervalEnd() + ",");
		}
		
		String resultInterval = (stringBuilder.toString().substring(0, stringBuilder.toString().length()-1));
		return resultInterval;
	}
	
}
