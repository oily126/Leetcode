public class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0, cnt = 0, begin = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt = -1;
            for (int j = 0; j <= i && j + i < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    cnt += 2;
                    if (maxLen < cnt) {
                        maxLen = cnt;
                        begin = i - j;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            cnt = 0;
            for (int j = 0; j <= i && i + j + 1 < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j + 1)) {
                    cnt += 2;
                    if (maxLen < cnt) {
                        maxLen = cnt;
                        begin = i - j;
                    }
                } else {
                    break;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}