package com.submission.intervalSplitter.model;


public class IntervalObject {

	private int intervalStart;
	private int intervalEnd;
	
	public IntervalObject() {
		intervalStart = 0;
		intervalEnd = 0;
		// TODO initialize values with default constructor
	}

	public IntervalObject(int s, int e) {
		super();
		this.intervalStart = s;
		this.intervalEnd = e;
	}

	public int getIntervalStart() {
		return intervalStart;
	}

	public void setIntervalStart(int intervalStart) {
		this.intervalStart = intervalStart;
	}

	public int getIntervalEnd() {
		return intervalEnd;
	}

	public void setIntervalEnd(int intervalEnd) {
		this.intervalEnd = intervalEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intervalEnd;
		result = prime * result + intervalStart;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntervalObject other = (IntervalObject) obj;
		if (intervalEnd != other.intervalEnd)
			return false;
		if (intervalStart != other.intervalStart)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IntervalObject [intervalStart=" + intervalStart + ", intervalEnd=" + intervalEnd + "]";
	}
	
	
	
	
}
