public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] used = new boolean[10];
        return dfs(0, n, used) + 1;
    }
    public int dfs(int num, int n, boolean[] visited) {
        if (num == n) {
            if (n > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int sum = 0;
        for (int i = (num == 0) ? 1 : 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (num == 0) {
                    for (int j = num + 1; j <= n; j++) {
                        sum += dfs(num + 1, j, visited);
                    }
                } else {
                    sum += dfs(num + 1, n, visited);
                }
                visited[i] = false;
            }
        }
        return sum;
    }
}