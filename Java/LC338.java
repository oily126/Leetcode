public class Solution {
    public int[] countBits(int num) {
        int[] ones = new int[num + 1];
        int i, last = 0;
        ones[0] = 0;
        for (i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                ones[i] = 1;
                last = i;
            } else {
                ones[i] = ones[i - last] + 1;
            }
        }
        return ones;
    }
}