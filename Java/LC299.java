public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> m = new HashMap<>();
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (m.getOrDefault(secret.charAt(i), 0) < 0) {
                    cow++;
                }
                m.put(secret.charAt(i), m.getOrDefault(secret.charAt(i), 0) + 1);
                if (m.getOrDefault(guess.charAt(i), 0) > 0) {
                    cow++;
                }
                m.put(guess.charAt(i), m.getOrDefault(guess.charAt(i), 0) - 1);
            }
        }
        
        return bull + "A" + cow + "B";
    }
}