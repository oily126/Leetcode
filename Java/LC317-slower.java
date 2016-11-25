public class Solution {
    public int shortestDistance(int[][] grid) {
        Queue<int[]> next = new LinkedList<>();
        Queue<int[]> from = new LinkedList<>();
        int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        Set<int[]>[][] meet = new HashSet[m][n];
        int[][] len = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] position = new int[] {i, j};
                    next.add(position);
                    from.add(position);
                    meet[i][j] = new HashSet<>();
                    meet[i][j].add(position);
                    cnt++;
                }
            }
        }
        int minLen = Integer.MAX_VALUE;
        int step = 0;
        while (next.size() > 0) {
            step++;
            for (int size = next.size(); size > 0; size--) {
                int[] point = next.poll();
                int[] p = from.poll();
                for (int i = 0; i < dir.length; i++) {
                    int x = point[0] + dir[i][0];
                    int y = point[1] + dir[i][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                        if (meet[x][y] == null) {
                            meet[x][y] = new HashSet<>();
                        }
                        boolean updated = false;
                        if (!meet[x][y].contains(p)) {
                            updated = true;
                            len[x][y] += step;
                            meet[x][y].add(p);
                            //System.out.println(x+" "+y+"<-"+p[0]+" "+p[1]+" with length "+distance[x][y][p[0]][p[1]]);
                        }
                        
                        if (updated) {
                            if (meet[x][y].size() == cnt && updated) {
                                minLen = Math.min(minLen, len[x][y]);
                                //System.out.println(x+" "+y+" "+len);
                            }
                            next.offer(new int[] {x, y});
                            from.offer(p);
                        }
                    }
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