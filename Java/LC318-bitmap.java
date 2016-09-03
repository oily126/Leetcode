public class Solution {
    public int maxProduct(String[] words) {
        int[] bitmap = new int[words.length];
        //Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bitmap[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        
        int maxP = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                //if (words[i].length() * words[j].length() <= maxP) {
                //    break;
                //}
                if ((bitmap[i] & bitmap[j]) == 0) {
                    maxP = Math.max(maxP, words[i].length() * words[j].length());
                }
            }
        }
        
        return maxP;
    }
}