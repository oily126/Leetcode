public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) return 0;
        int[] sums = new int[costs[0].length], lastSums = new int[costs[0].length];
        
        for (int j = 0; j < 3; j++) sums[j] = costs[0][j];
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                lastSums[j] = sums[j];
                sums[j] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        sums[j] = Math.min(sums[j], lastSums[k] + costs[i][j]);
                    }
                }
                
            }
        }
        return Math.min(sums[0], Math.min(sums[1], sums[2]));
    }
}