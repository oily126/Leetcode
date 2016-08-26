public class Solution {
    public int lengthLongestPath(String input) {
        int i, level, curLen = 0, cnt = 0, st = -1;
        boolean isFile = false;
        Stack<String> dir = new Stack<>();
        int ans = 0;
        
        for (i = 0; i <= input.length(); i++) {
            char ch = (i == input.length()) ? '\n' : input.charAt(i);
            if (ch == '\n') {
                while (dir.size() > cnt) {
                    curLen -= dir.pop().length();
                }
                if (st < 0) st = i;
                dir.push(input.substring(st, i));
                curLen += dir.peek().length();
                if (isFile) {
                    ans = Math.max(ans, curLen + dir.size() - 1);
                }
                cnt = 0;
                st = -1;
                isFile = false;
            } else if (ch == '\t') {
                cnt++;
            } else {
                if (st < 0) st = i;
                if (ch == '.') isFile = true;
            }
        }
        return ans;
    }
}