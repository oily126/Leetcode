public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> minNum = new Stack<>();
        int i;
        for (i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (k > 0 && !minNum.empty() && minNum.peek() > ch) {
                minNum.pop();
                k--;
            }
            minNum.push(ch);
        }
        while (k > 0 && !minNum.empty()) {
            minNum.pop();
            k--;
        }
        char[] sArr = new char[minNum.size()];
        for (i = sArr.length - 1; i >= 0; i--) {
            sArr[i] = minNum.pop();
        }
        for (i = 0; i < sArr.length; i++) {
            if (sArr[i] != '0') break;
        }
        String s = (new String(sArr)).substring(i);
        return s.equals("") ? "0" : s;
    }
}