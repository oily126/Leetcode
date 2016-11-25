public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i;
        int[] numsOfSentence = new int[sentence.length];
        int[] nextIndex = new int[sentence.length];
        int len = 0;
        int sum = 0;
        int begin = 0;
        for (i = 0; i < sentence.length; i++) {
            len = cols;
            begin = i;
            while (len >= sentence[begin].length()) {
                len -= sentence[begin].length();
                len--;
                if (++begin >= sentence.length) {
                    begin = 0;
                    numsOfSentence[i]++;
                }
            }
            nextIndex[i] = begin;
            //System.out.println(numsOfSentence[i]+" "+nextIndex[i]);
        }
        begin = 0;
        for (i = 0; i < rows; i++) {
            sum += numsOfSentence[begin];
            begin = nextIndex[begin];
        }
        return sum;
    }
}