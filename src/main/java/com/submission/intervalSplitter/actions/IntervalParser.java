package com.submission.intervalSplitter.actions;


import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.submission.intervalSplitter.model.IntervalObject;

public class IntervalParser implements Comparable<Integer> {

	public static ArrayList<IntervalObject> parse(String includeIntervals) throws Exception {
		ArrayList<IntervalObject> intervalSet = new ArrayList<>();
		
			if(includeIntervals != null && !includeIntervals.trim().isEmpty())
				{
				String[] tokens = includeIntervals.split(",");
				Logger logger = Logger.getLogger(IntervalParser.class);
				
				try{
					for(int i=0;i<tokens.length;i++)
					{
						String range = tokens[i].trim();
						String[] t = range.split("-");
						
						IntervalObject io = new IntervalObject();
						ArrayList<Integer> interval = new ArrayList<Integer>();
						for(int j=0;j<2;j++){
							interval.add(Integer.parseInt(t[j]));
						}
						interval.sort(null);
						io.setIntervalStart(interval.get(0));
						io.setIntervalEnd(interval.get(1));;
						
						intervalSet.add(io);
						
					}
				}
				
				catch(NumberFormatException nfe) {
					logger.error("Number format exception has been caught.Intervals should contain Intergers only");
				}
				catch(Exception e){
					logger.error("An error has been caught.The error message is: " + e.getMessage());
				}
				
				return intervalSet;
			}
		
			else{
				return intervalSet;
			}
		
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
