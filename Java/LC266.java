public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Integer cnt : m.values()) {
            if (cnt % 2 != 0) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}