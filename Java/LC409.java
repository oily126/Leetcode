public class Solution {
    public int longestPalindrome(String s) {
        int i, sum = 0;
        int odd = 0;
        Map<Character, Integer> m = new HashMap<>();
        for (i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Character ch : m.keySet()) {
            int num = m.get(ch);
            if (num % 2 == 1) {
                odd = 1;
                num--;
            }
            sum += num;
        }
        return sum + odd;
    }
}