package com.submission.intervalSplitter.model;

public class IntervalOverlapPoint implements Comparable<IntervalOverlapPoint> {
	public int value;
	public OverlapMode overlapmode;



	public IntervalOverlapPoint(int value, OverlapMode overlapmode) {
		this.value = value;
		this.overlapmode = overlapmode;
	}

	@Override
	public int compareTo(IntervalOverlapPoint other) {

		if (other.value == this.value) {

			int j = this.overlapmode.ordinal() < other.overlapmode.ordinal() ? -1 : 1;
			return j;

		} else {

			int i = this.value < other.value ? -1 : 1;
			return i;
		}
	}

	public enum OverlapMode {
		IncludeIntervalEnd, ExcludeIntervalEnd, ExcludeIntervalStart, IncludeIntervalStart
	}

}
