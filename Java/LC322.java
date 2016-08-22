public class Solution {
    public int coinChange(int[] coins, int amount) {
        int i, j;
        int[] sumCost = new int[amount + 1];
        sumCost[0] = 0;
        for (i = 1; i <= amount; i++) {
            sumCost[i] = Integer.MAX_VALUE;
            for (j = 0; j < coins.length; j++) {
                if (i >= coins[j] && sumCost[i - coins[j]] != Integer.MAX_VALUE) {
                    sumCost[i] = Math.min(sumCost[i], sumCost[i - coins[j]] + 1);
                }
            }
        }
        if (sumCost[amount] == Integer.MAX_VALUE) return -1;
        else return sumCost[amount];
    }
}