public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    left[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1;
                        left[i][j] = 1;
                    }
                    if (i > 0) up[i][j] += up[i - 1][j];
                    if (j > 0) left[i][j] += left[i][j - 1];
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    right[i][j] = 0;
                } else {
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1;
                        right[i][j] = 1;
                    }
                    if (i < m - 1) down[i][j] += down[i + 1][j];
                    if (j < n - 1) right[i][j] += right[i][j + 1];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    ans = Math.max(ans, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return ans;
    }
}