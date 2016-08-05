public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        
        int i, j, m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        
        f[0][0] = grid[0][0];
        for (j = 1; j < n; j++) f[0][j] = f[0][j - 1] + grid[0][j];
        
        for (i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
            for (j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        
        return f[m - 1][n - 1];
    }
}