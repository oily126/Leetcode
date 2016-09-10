public class Solution {
    public int hIndex(int[] citations) {
        int i, h, n = citations.length;
        int[] bucket = new int[n + 1];
        for (i = 0; i < n; i++) {
            if (citations[i] >= n) {
                bucket[n]++;
            } else {
                bucket[citations[i]]++;
            }
        }
        for (h = n; h >= 0; h--) {
            if (h < n) {
                bucket[h] += bucket[h + 1];
            }
            if (bucket[h] >= h) {
                return h;
            }
        }
        return 0;
    }
}