public class Solution {
    public String parseTernary(String expression) {
        if (expression.length() == 0) return "";
        int l = 0, r = expression.length() - 1;
        while (l < r) {
            if (l + 1 >= r) return ""; 

            int pos = findPosition(expression, l + 2, r);
            if (pos < 0) return "";
            if (expression.charAt(l) == 'T') {
                l += 2;
                r = pos - 1;
            } else {
                l = pos + 1;
            }
        }
        return expression.substring(l, r + 1);
    }
    private int findPosition(String expression, int l, int r) {
        int cnt = 1;
        for (int i = l; i <= r; i++) {
            if (expression.charAt(i) == '?') {
                cnt++;
            } else if (expression.charAt(i) == ':') {
                cnt--;
            }
            if (cnt == 0) return i;
        }
        return -1;
    }
}