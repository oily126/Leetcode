public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int i, j, n = grid[0].length, cnt = 0;
        boolean[][] used = new boolean[m][n];
        
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    dfs(grid, used, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public void dfs(char[][] grid, boolean[][] used,
        int x, int y) {
        int[][] mv = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int i, nx, ny;
        used[x][y] = true;
        for (i = 0; i < 4; i++) {
            nx = x + mv[i][0];
            ny = y + mv[i][1];
            if (nx >= 0 && nx < grid.length
                && ny >= 0 && ny < grid[0].length
                && grid[nx][ny] == '1' && !used[nx][ny]) {
                dfs(grid, used, nx, ny);    
            }
        }
    }
}