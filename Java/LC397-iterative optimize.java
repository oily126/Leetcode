public class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n == 3) return 2;
        if (n == Integer.MAX_VALUE) return 32;
        
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            if ((n + 1) % 4 == 0) {
                return integerReplacement(n + 1) + 1;
            } else {
                return integerReplacement(n - 1) + 1;
            }
        }
    }
}