public class Solution {
    public int shortestDistance(int[][] grid) {
        Queue<int[]> next = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        int step = 0;
        int[][] len = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] position = new int[] {i, j};
                    boolean[][] visited = new boolean[m][n];
                    next.offer(position);
                    step = 0;
                    while (next.size() > 0) {
                        step++;
                        for (int size = next.size(); size > 0; size--) {
                            int[] point = next.poll();
                            for (int k = 0; k < dir.length; k++) {
                                int x = point[0] + dir[k][0];
                                int y = point[1] + dir[k][1];
                                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == cnt) {
                                    visited[x][y] = true;
                                    len[x][y] += step;
                                    next.offer(new int[] {x, y});
                                    grid[x][y]--;
                                }
                            }
                        }
                    }
                    if (step == 1) return -1;
                    cnt--;
                }
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == cnt) {
                    minLen = Math.min(minLen, len[i][j]);
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLen;
        }
    }
}