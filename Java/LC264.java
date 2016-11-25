public class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        int[] indexes = new int[3];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < indexes.length; j++) {
                ugly[i] = Math.min(ugly[i], ugly[indexes[j]] * factors[j]);
            }
            for (int j = 0; j < indexes.length; j++) {
                if (ugly[i] == ugly[indexes[j]] * factors[j]) {
                    indexes[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}