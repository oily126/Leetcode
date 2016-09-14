public class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] ref = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int len = num.length();
        for (int i = 0; i <= len / 2; i++) {
            if (ref[num.charAt(i) - '0'] != num.charAt(len - i - 1) - '0') {
                return false;
            }
        }
        return true;
    }
}