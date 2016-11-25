public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> minChar = new Stack<>();
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!minChar.empty() && !used[ch - 'a'] && minChar.peek() > ch && count[minChar.peek() - 'a'] > 0) {
                used[minChar.pop() - 'a'] = false;
            }
            if (!used[ch - 'a']) minChar.push(ch);
            used[ch - 'a'] = true;
            count[s.charAt(i) - 'a']--;
        }
        char[] ansArr = new char[minChar.size()];
        for (int i = ansArr.length - 1; i >= 0; i--) {
            ansArr[i] = minChar.pop();
        }
        return new String(ansArr);
    }
}