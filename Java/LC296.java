public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] x = new int[m], y = new int[n];
        int i = 0, xp = 0, yp = 0, sum = 0;
        for (i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x[i]++;
                    y[j]++;
                    sum++;
                }
            }
        }
        int tmp = 0;
        for (i = 0; i < m; i++) {
            tmp += x[i];
            if (tmp >= (sum + 1) / 2) {
                xp = i;
                break;
            }
        }
        tmp = 0;
        for (i = 0; i < n; i++) {
            tmp += y[i];
            if (tmp >= (sum + 1) / 2) {
                yp = i;
                break;
            }
        }
        tmp = 0;
        for (i = 0; i < m; i++) tmp += Math.abs(i - xp) * x[i];
        for (i = 0; i < n; i++) tmp += Math.abs(i - yp) * y[i];
        
        return tmp;
    }
}