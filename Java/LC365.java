public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0) return y == z || x == z;
        if (y == 0) return x == z || y == z;
        if (x + y >= z) {
            return z % gcd(x, y) == 0;
        } else {
            return false;
        }
    }
    int gcd(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;
        return gcd(y % x, x);
    }
}