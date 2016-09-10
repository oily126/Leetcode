public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (citations[mid] >= n - mid) {
                if (mid > 1 && citations[mid - 1] <= n - mid || mid == 0) {
                    return n - mid;
                } else {
                    r = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return n - l;
    }
}