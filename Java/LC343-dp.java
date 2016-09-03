public class Solution {
    public int integerBreak(int n) {
        int i, j;
        int[] f = new int[n + 1];
        f[2] = 1;
        for (i = 3; i <= n; i++) {
            for (j = 1; j < i; j++) {
                f[i] = Math.max(f[i], j * Math.max(i - j, f[i - j]));
            }
        }
        return f[n];
    }
}