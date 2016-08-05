public class Solution {
    public double myPow(double x, int n) {
        double pow = 1, y = 1;
        int i;
        List<Integer> one = new ArrayList<>();
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                x = 1 / x;
                y = x;
                n = - (n + 1);
            } else {
                n = -n;
                x = 1 / x;
            }
        }
        while (n > 0) {
            one.add(n % 2);
            n /= 2;
        }
        for (i = one.size() - 1; i >= 0; i--) {
            pow *= pow;
            if (one.get(i) == 1) pow *= x;
        }
        return pow * y;
    }
}