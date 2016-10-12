public class Solution {
    public int numberOfPatterns(int m, int n) {
        if (m > n) return 0;
        
        int[][] middle = new int[10][10];
        boolean[] used = new boolean[10];
        middle[1][3] = 2;
        middle[3][1] = 2;
        middle[4][6] = 5;
        middle[6][4] = 5;
        middle[7][9] = 8;
        middle[9][7] = 8;
        middle[1][7] = 4;
        middle[7][1] = 4;
        middle[2][8] = 5;
        middle[8][2] = 5;
        middle[3][9] = 6;
        middle[9][3] = 6;
        middle[1][9] = 5;
        middle[9][1] = 5;
        middle[3][7] = 5;
        middle[7][3] = 5;
        used[0] = true;
        int ans = 0;
        for (int i = m; i <= n; i++) {
            ans += helper(1, 1, i, middle, used) * 4;
            ans += helper(1, 2, i, middle, used) * 4;
            ans += helper(1, 5, i, middle, used);
        }
        return ans;
    }
    private int helper(int index, int last, int n, int[][] middle, boolean[] used) {
        if (index > n) return 0;
        if (index == n) return 1;
        int ans = 0;
        used[last] = true;
        for (int i = 1; i <= 9; i++) {
            if (used[i] || !used[middle[last][i]]) continue;
            ans += helper(index + 1, i, n, middle, used);
        }
        used[last] = false;
        return ans;
    }
}