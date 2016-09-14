public class Solution {
    public int reverse(int x) {
        int n = 0;
        while (x != 0) {
            if (n < Integer.MIN_VALUE / 10) return 0;
            if (n > Integer.MAX_VALUE / 10) return 0;
            if (n == Integer.MIN_VALUE / 10 && x % 10 < -8) return 0;
            if (n == Integer.MAX_VALUE / 10 && x % 10 > 7) return 0;
            
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n;
    }
}