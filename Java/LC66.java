public class Solution {
    public int[] plusOne(int[] digits) {
        int i;
        for (i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                break;
            }
        }
        
        if (i == digits.length) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        digits[digits.length - 1]++;
        for (i = digits.length - 1; i > 0; i--) {
            digits[i - 1] += digits[i] / 10;
            digits[i] %= 10;
        }
        return digits;
    }
}