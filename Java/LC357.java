public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int i;
        int count = 9, sum = 10;
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            n = 10;
        }
        for (i = 1; i < n; i++) {
            count *= (10 - i);
            sum += count;
        }
        return sum;
    }
}