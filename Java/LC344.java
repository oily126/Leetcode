public class Solution {
    public String reverseString(String s) {
        int i;
        int n = s.length();
        char[] sArr = s.toCharArray();
        char ch;
        for (i = 0; i < n / 2; i++) {
            ch = sArr[i];
            sArr[i] = sArr[n - i - 1];
            sArr[n - i - 1] = ch;
        }
        return new String(sArr);
    }
}