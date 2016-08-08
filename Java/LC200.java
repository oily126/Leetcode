public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        
        int i, j, m = grid.length, n = grid[0].length;
        int cnt = 0;
        int[] f = new int[m * n];
        
        for (i = 0; i < m * n; i++) {
            f[i] = -1;
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int pos = i * n + j, pos1, pos2;
                    pos1 = pos2 = f[pos] = pos;
                    if (i > 0 && grid[i - 1][j] == '1') pos1 = Math.min(f[pos], f[(i - 1) * n + j]);
                    if (j > 0 && grid[i][j - 1] == '1') pos2 = Math.min(f[pos], f[i * n + j - 1]);
                    if (pos1 != pos2) {
                        f[Math.max(pos1, pos2)] = f[Math.min(pos1, pos2)];
                    }
                    f[pos] = Math.min(pos1, pos2);
                }
            }
        }
        for (i = 0; i < m * n; i++) {
            if (f[i] >= 0 && find(i, f) == i) cnt++;
        }
        return cnt;
    }
    
    public int find(int i, int[] f) {
        if (f[i] == i) return i;
        f[i] = find(f[i], f);
        return f[i];
    }
}