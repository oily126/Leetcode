public class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> m = new HashMap<>();
        List<String> ans = new ArrayList<>();
        char oddCh = ' ';
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Character ch : m.keySet()) {
            if (m.get(ch) % 2 == 1) {
                cnt++;
                oddCh = ch;
            }
            sum += m.get(ch);
        }
        if (cnt > 1) return ans;
        if (cnt == 1) {
            sum--;
            sb.append(oddCh);
        }
        helper(m, ans, sb, sum);
        return ans;
    }
    private void helper(Map<Character, Integer> m, List<String> ans, 
        StringBuilder sb, int sum) {
        if (sum == 0) {
            ans.add(sb.toString());
        } else {
            for (Character ch : m.keySet()) {
                if (m.get(ch) > 1) {
                    StringBuilder sb1 = new StringBuilder(sb);
                    sb1.insert(0, ch);
                    sb1.append(ch);
                    m.put(ch, m.get(ch) - 2);
                    helper(m, ans, sb1, sum - 2);
                    m.put(ch, m.get(ch) + 2);
                }
            }
        }
    }
}