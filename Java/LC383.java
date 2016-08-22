public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> m = new HashMap<>();
        int i;
        for (i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            Integer num = m.get(ch);
            if (num != null) {
                m.put(ch, num.intValue() + 1);
            } else {
                m.put(ch, 1);
            }
        }
        for (i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            Integer num = m.get(ch);
            if (num != null) {
                if (num.intValue() > 1) {
                    m.put(ch, num.intValue() - 1);
                } else {
                    m.remove(ch);
                }
            }
        }
        return m.size() == 0;
    }
}