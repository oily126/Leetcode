public class Solution {
    public int numWays(int n, int k) {
        if (k == 0 || n == 0) return 0;
        int[] f = new int[2], g = new int[2];
        f[0] = k;
        f[1] = 0;
        for (int i = 1; i < n; i++) {
            g[0] = f[0] * (k - 1) + f[1] * (k - 1);
            g[1] = f[0];
            f[0] = g[0];
            f[1] = g[1];
        }
        return f[0] + f[1];
    }
}