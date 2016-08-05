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
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) return a.start - b.start;
                return a.end - b.end;
            }
        });
        List<Interval> ans = new ArrayList<>();
        Interval cur = null;
        for (Interval tmp : intervals) {
            if (cur != null) {
                if (cur.end >= tmp.start) {
                    cur.end = Math.max(cur.end, tmp.end);
                    continue;
                } else ans.add(cur);
            }
            cur = tmp;
        }
        if (cur != null) ans.add(cur);
        return ans;
    }
}