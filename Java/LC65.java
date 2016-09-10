public class Solution {
    public boolean isNumber(String s) {
        boolean gotDot = false;
        boolean gotE = false;
        boolean gotNumAfterE = true;
        boolean gotNum = false;
        boolean gotSpace = false;
        boolean gotOp = false;
        int len = 0, begin = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len = i + 1;
                break;
            }
        }
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '.': 
                    if (gotDot || gotE) {
                        return false;
                    }
                    gotDot = true;
                    break;
                case 'e':
                case 'E':
                    if (gotE || !gotNum) {
                        return false;
                    }
                    gotE = true;
                    gotNumAfterE = false;
                    gotDot = false;
                    gotOp = false;
                    break;
                case '+':
                case '-':
                    if (i != begin && s.charAt(i - 1) != 'e') {
                        return false;
                    }
                    gotOp = true;
                    gotNum = false;
                    break;
                case ' ':
                    if (gotDot || gotNum || gotE || gotOp) {
                        return false;
                    }
                    begin = i + 1;
                    break;
                default:
                    if (ch >= '0' && ch <= '9') {
                        gotNum = true;
                        gotNumAfterE = true;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return gotNum && gotNumAfterE;
    }
}