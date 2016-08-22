public class Solution {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        int i, j, len;
        for (i = 0; i <= n; i++) f[i][i] = 0;
        for (len = 1; len <= n; len++) {
            for (i = 1; i + len <= n; i++) {
                f[i][i + len] = i + f[i + 1][i + len];
                for (j = i + 1; j < i + len; j++) {
                    f[i][i + len] = Math.min(f[i][i + len], j + Math.max(f[i][j - 1], f[j + 1][i + len]));
                }
                f[i][i + len] = Math.min(f[i][i + len], j + f[i][j - 1]);
            }
        }
        return f[1][n];
    }
}