public class Solution {
    public String decodeString(String s) {
        return helper(s);
    }
    private String helper(String s) {
        int cnt = 0;
        int para = -1, pcnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                pcnt++;
                if (para < 0) para = i;
            } else if (ch == ']') {
                pcnt--;
                if (pcnt == 0) {
                    String p = helper(s.substring(para + 1, i));
                    for (; cnt > 0; cnt--) sb.append(p);
                    para = -1;
                }
            } else {
                if (para < 0) {
                    if (ch >= '0' && ch <= '9') {
                        cnt = cnt * 10 + ch - '0';
                    } else {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}