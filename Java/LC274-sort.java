public class Solution {
    public int hIndex(int[] citations) {
        int i, n = citations.length;
        Arrays.sort(citations);
        if (citations.length <= 0 || citations[0] >= n) return n;
        for (i = 1; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h && citations[i - 1] <= h) {
                return h;
            }
        }
        return 0;
    }
}