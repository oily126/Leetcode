/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Comparator<Interval> intervalCmp = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
				// if (a.start != b.start ) return a.start - b.start;
				// return a.end - b.end;
                if (a.start != b.start ) return a.start > b.start ? 1 : -1;
                if (a.end != b.end) return a.end > b.end ? 1 : -1;
                return 0;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, intervalCmp);
        //for (Interval a : intervals) System.out.println(a.start+" "+a.end);
        for (int i = 0; i < intervals.length; i++) {
            if (pq.size() > 0 && pq.peek() <= intervals[i].start) {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return pq.size();
    }
}