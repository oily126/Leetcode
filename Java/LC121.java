public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = 0;
        if (prices.length > 0) min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}