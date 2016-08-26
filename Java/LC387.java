public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int i;
        for (i = 0; i < s.length(); i++) {
            Integer count = m.get(s.charAt(i));
            if (count == null) {
                m.put(s.charAt(i), 1);
            } else {
                m.put(s.charAt(i), count.intValue() + 1);
            }
        }
        for (i = 0; i < s.length(); i++) {
            if (m.get(s.charAt(i)).intValue() == 1) return i;
        }
        return -1;
    }
}