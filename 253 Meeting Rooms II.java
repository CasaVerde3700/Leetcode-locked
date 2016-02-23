/*
Given an array of meeting time intervals consisting of 
start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.
*/

// time O(NlogN)

public int minMeetingRooms(Interval[] intervals) {
	Arrays.sort(intervals, new Comparator<Interval>(){
		public int compare(Interval i1, Interval i2) {
			return i1.start - i2.start;
		}
	});

	PriorityQueue<Integer> endTimes = new PriorityQueue<>();

	endTimes.offer(intervals[0].end);

	for (int i = 1; i < intervals.length; i++) {
		if (intervals[i].start >= endTimes.peek()) {
			endTimes.poll();
		}
		endTimes.offer(intervals[i].end);
	}

	return endTimes.size();
}