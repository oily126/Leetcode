public class Solution {
    public int myAtoi(String str) {
        int i, op = 1;
        double tmp = 0;
        boolean gotNum = false;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                 tmp = tmp * 10 + ch - '0';
                 gotNum = true;
            } else if (ch == '-' || ch == '+') {
                if (ch == '-') {
                    if (gotNum) {
                        return 0;
                    } else {
                        op = -1;
                    }
                } else if (gotNum) {
                    return 0;
                }
                gotNum = true;
            } else {
                break;
            }
            if (tmp * op <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (tmp * op >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        tmp *= op;
        return (int) tmp;
    }
}