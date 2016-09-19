public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i;
        int pos1 = -1, pos2 = -1;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
                if (pos1 >= 0 && pos2 >= 0) {
                    ans = Math.min(pos1 - pos2, ans);
                }
            }
            
            if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 >= 0 && pos2 >= 0 && !word1.equals(word2)) {
                ans = Math.min(Math.abs(pos1 - pos2), ans);
            }
        }
        return ans;
    }
}