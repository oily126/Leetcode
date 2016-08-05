public class Solution {
    public String countAndSay(int n) {
        int i, j, cnt = 1;
        StringBuilder sb = new StringBuilder("1");
        String s;
        for (i = 1; i < n; i++) {
            s = sb.toString();
            sb.setLength(0);
            for (j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (j < s.length() - 1 && ch == s.charAt(j + 1)) {
                    cnt++;
                } else {
                    sb.append(((Integer)cnt).toString());
                    sb.append(ch);
                    cnt = 1;
                }
            }
        }
        return sb.toString();
    }
}