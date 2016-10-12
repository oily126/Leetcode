public class Solution {
    public int longestSubstring(String s, int k) {
        int i, l, maxLen = 0, cnt = 0;
        Map<Character, Integer> num = new HashMap<>();
        System.out.println(s);
        for (i = 0; i < s.length(); i++) {
            num.put(s.charAt(i), num.getOrDefault(s.charAt(i), 0) + 1);
        }
        l = 0;
        for (i = 0; i < s.length(); i++) {
            if (num.get(s.charAt(i)) < k) {
                cnt++;
                if (i > l) {
                    maxLen = Math.max(maxLen, longestSubstring(s.substring(l, i), k));
                }
                l = i + 1;
            }
        }
        if (cnt == 0) return s.length();
        maxLen = Math.max(maxLen, longestSubstring(s.substring(l, i), k));
        return maxLen;
    }
}