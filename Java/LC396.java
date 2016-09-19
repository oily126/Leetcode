public class Solution {
    public int maxRotateFunction(int[] A) {
        int i, n = A.length, sum = 0, ans, total = 0;
        for (i = 0; i < n; i++) {
            sum += A[i] * i;
            total += A[i];
        }
        ans = sum;
        for (i = n - 1; i > 0; i--) {
            sum = sum - A[i] * (n - 1) + total - A[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}