package com.submission.intervalSplitter.core;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.submission.intervalSplitter.actions.IntervalAppender;
import com.submission.intervalSplitter.actions.IntervalParser;
import com.submission.intervalSplitter.actions.IntervalSplit;
import com.submission.intervalSplitter.model.IntervalObject;

public class MainBusiness {

	public static String splitInputInterval(String includeIntervals, String excludeIntervals) {
		// TODO Auto-generated method stub
		ArrayList<IntervalObject> includeIntervalRanges = new ArrayList<IntervalObject>();
		ArrayList<IntervalObject> excludeIntervalRanges = new ArrayList<IntervalObject>();
		String resultInterval = null;
		
		try{
			if(includeIntervals!= null && !includeIntervals.trim().isEmpty()){
				includeIntervalRanges = IntervalParser.parse(includeIntervals);
			}
			if(excludeIntervals.length()>0){
				excludeIntervalRanges = IntervalParser.parse(excludeIntervals);
			}
			
			ArrayList<IntervalObject> splitInterval = IntervalSplit.split(includeIntervalRanges,excludeIntervalRanges);
			resultInterval = IntervalAppender.append(splitInterval);
		}
		
		catch(IndexOutOfBoundsException ioe){
			Logger logger = Logger.getLogger(MainBusiness.class);
			logger.error("Index out of range exception.The error message is :" + ioe.getMessage());
			return "exception";
		}
		catch(Exception e){
			Logger logger = Logger.getLogger(MainBusiness.class);
			logger.error("An error occured while processing the request.The error message is :"+ e.getMessage());
			return "exception";
		}
		
		return resultInterval;
	}

}
