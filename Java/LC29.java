public class Solution {
    public int divide(int dividend, int divisor) {
        int ans;
        int iter = 0, sum = 0;
        for (i = 0; dividend >= 0; i <<= 1) {
            sum += divisor;
            dividend -= sum;
            iter++;
        }
        return divide(dividend + sum, iter);
    }
}