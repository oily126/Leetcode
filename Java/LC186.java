public class Solution {
    public void reverseWords(char[] s) {
        int start = 0;
        int i, j, k;
        i = s.length;
        for (j = start, k = i - 1; j < k; k--, j++) {
            char tmp = s[j];
            s[j] = s[k];
            s[k] = tmp;
        }
        for (i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                for (j = start, k = i - 1; j < k; k--, j++) {
                    char tmp = s[j];
                    s[j] = s[k];
                    s[k] = tmp;
                }
                start = i + 1;
            }
        }
    }
}