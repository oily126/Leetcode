public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        boolean[][] isP = new boolean[m][n];
        boolean[][] isA = new boolean[m][n];
        int i, j;
        Queue<int[]> next = new LinkedList<>();
        for (i = 0; i < m; i++) {
            isP[i][0] = true;
            next.offer(new int[] {i, 0});
            isA[i][n - 1] = true;
            next.offer(new int[] {i, n - 1});
        }
        for (i = 0; i < n; i++) {
            isP[0][i] = true;
            next.offer(new int[] {0, i});
            isA[m - 1][i] = true;
            next.offer(new int[] {m - 1, i});
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!next.isEmpty()) {
            for (int size = next.size() - 1; size >= 0; size--) {
                int[] p = next.poll();
                for (i = 0; i < 4; i++) {
                    int x = dir[i][0] + p[0];
                    int y = dir[i][1] + p[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] >= matrix[p[0]][p[1]]) {
                        if (!isP[x][y] && isP[p[0]][p[1]] || !isA[x][y] && isA[p[0]][p[1]]) {
                            next.offer(new int[] {x, y});
                            isP[x][y] |= isP[p[0]][p[1]];
                            isA[x][y] |= isA[p[0]][p[1]];
                        }
                    }
                }
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (isP[i][j] && isA[i][j]) {
                    ans.add(new int[] {i, j});
                }
            }
        }
        return ans;
    }
}