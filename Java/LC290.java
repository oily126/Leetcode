public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Set<String> strUsed = new HashSet<>();
        Map<Character, String> pattern2str = new HashMap<>();
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        for (int i = 0; i < words.length; i++) {
			char ch = pattern.charAt(i);
            if (pattern2str.containsKey()) {
                if (!words[i].equals(pattern2str.get(ch))) {
                    return false;
                }
            } else {
                if (strUsed.contains(words[i])) {
                    return false;
                }
                strUsed.add(words[i]);
                pattern2str.put(ch, words[i]);
            }
        }
        return true;
    }
}