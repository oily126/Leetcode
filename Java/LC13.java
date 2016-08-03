public class Solution {
    public int romanToInt(String s) {
        int ans = 0, i, val1, val2;
        int[] val = new int[] {1, 5, 10, 50, 100, 500, 1000};
        char[] roman = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Map<Character, Integer> m = new HashMap<>();
        for (i = 0; i < val.length; i++) {
            m.put(roman[i], val[i]);
        }
        for (i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i), next = s.charAt(i + 1);
            val1 = m.get(ch).intValue();
            val2 = m.get(next).intValue();
            if (val1 < val2) {
                ans += val2 - val1;
                i++;
            } else {
                ans += val1;
            }
        }
        
        if (i < s.length()) {
            ans += m.get(s.charAt(i)).intValue();
        }
        return ans;
    }
}