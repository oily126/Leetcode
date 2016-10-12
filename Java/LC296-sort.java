public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        int cnt = 0, xp, yp;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                    cnt++;
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        
        xp = x.get(cnt / 2);
        yp = y.get(cnt / 2);
        cnt = 0;
        for (Integer xi : x) cnt += Math.abs(xi - xp);
        for (Integer yi : y) cnt += Math.abs(yi - yp);
        
        return cnt;
    }
}