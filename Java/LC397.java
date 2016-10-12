public class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        
        Set<Long> s = new HashSet<>();
        Queue<Long> q = new LinkedList<>();
        int cnt = 0;
        long nVal = n;
        q.offer(nVal);
        s.add(nVal);
        while (q.size() > 0) {
            cnt++;
            for (int size = q.size() - 1; size >= 0; size--) {
                long val = q.poll();
                if (val % 2 == 0) {
                    if (!s.contains(val / 2)) {
                        q.offer(val / 2);
                        s.add(val / 2);
                    }
                } else {
                    if (!s.contains(val + 1)) {
                        q.offer(val + 1);
                        s.add(val + 1);
                    }
                    if (!s.contains(val - 1)) {
                        q.offer(val - 1);
                        s.add(val - 1);
                    }
                }
                if (s.contains(1L)) return cnt;
            }
            
        }
        return -1;
    }
}