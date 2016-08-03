public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<>();
        int i;
        Character ch;
        Stack<Character> buf = new Stack<>();
        
        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');
        
        for (i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!m.containsKey(ch)) {
                buf.add(ch);
            } else {
                if (!buf.empty() && buf.peek().equals(m.get(ch))) {
                    buf.pop();
                } else {
                    return false;
                }
            }
        }
        return buf.empty();
    }
}