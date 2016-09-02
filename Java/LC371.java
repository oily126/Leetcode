public class Solution {
    public int getSum(int a, int b) {
        int c = a & b;
        a ^= b;
        while (c != 0) {
            b = c << 1;
            c = a & b;
            a ^= b;
        }
        return a;
    }
}