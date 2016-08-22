public class Solution {
    protected class Entry3 {
        public int val;
        public int x, y;
        public Entry3(int val1, int x1, int y1) {
            val = val1;
            x = x1;
            y = y1;
        }
    }
    protected class EntryComparator implements Comparator<Entry3> {
        public int compare(Entry3 e1, Entry3 e2) {
            return e1.val - e2.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Entry3> pq = 
            new PriorityQueue<Entry3>(k, new EntryComparator());
        int i;
        Entry3 entry = null;
        
        if (matrix.length == 0) return 0;
        for (i = 0; i < matrix[0].length; i++) pq.offer(new Entry3(matrix[0][i], 0, i));
        while (k > 0 && pq.size() > 0) {
            entry = pq.poll();
            k--;
            if (entry.x < matrix.length - 1) {
                pq.offer(new Entry3(matrix[entry.x + 1][entry.y], entry.x + 1, entry.y));
            }
        }
        return entry.val;
    }
}