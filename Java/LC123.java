public class Solution {
    public int maxProfit(int[] prices) {
        int i, min = 0, max1 = Integer.MIN_VALUE, max = 0;
        int[][] profit = new int[prices.length][2];
        
        if (prices.length > 0) {
            min = prices[0];
            profit[0][0] = 0;
        }
        for (i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            profit[i][0] = profit[i - 1][0];
            profit[i][0] = Math.max(profit[i][0], prices[i] - min);
            profit[i][1] = 0;
            profit[i][1] = Math.max(profit[i][1], prices[i] + max1);
            max1 = Math.max(max1, profit[i - 1][0] - prices[i]);
            max = Math.max(max, Math.max(profit[i][0], profit[i][1]));
        }
        return max;
    }
}