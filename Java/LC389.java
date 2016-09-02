public class Solution {
    public char findTheDifference(String s, String t) {
        int i;
        Map<Character, Integer> set = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (i = 0; i < t.length(); i++) {
            if (set.containsKey(t.charAt(i))) {
                char ch = t.charAt(i);
                if (set.get(ch).intValue() == 0) return t.charAt(i);
                set.put(ch, set.get(ch) - 1);
            } else {
                return t.charAt(i);
            }
        }
        return '\0';
    }
}