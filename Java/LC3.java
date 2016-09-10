public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (begin < i) {
                    set.remove(s.charAt(begin));
                    begin++;
                    if (s.charAt(begin - 1) == s.charAt(i)) {
                        break;
                    }
                }
            }
            set.add(s.charAt(i));
            maxLen = Math.max(i - begin + 1, maxLen);
        }
        return maxLen;
    }
}