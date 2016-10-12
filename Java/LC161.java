public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length(), len2 = t.length(), len;
        String tmp;
        int i, j;
        int cnt = 0;
        if (Math.abs(len1 - len2) > 1) return false;
        if (len1 > len2) {
            tmp = s;
            s = t;
            t = tmp;
            len = len1;
            len1 = len2;
            len2 = len;
        }
        if (len1 == len2) {
            for (i = 0; i < len1; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    cnt++;
                    if (cnt > 1) return false;
                }
            }
            if (cnt == 0) return false;
        } else {
            for (i = 0, j = 0; i < len1 && j < len2; i++, j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    i--;
                }
            }
            if (i < len1) return false;
        }
        return true;
    }
}