public class WordDistance {
    Map<String, List<Integer>> pos;
    public WordDistance(String[] words) {
        pos = new HashMap<>();
        //maxP = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!pos.containsKey(words[i])) {
                pos.put(words[i], new ArrayList<>());
            }
            pos.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> pos1 = pos.get(word1);
        List<Integer> pos2 = pos.get(word2);
        int i, j, len1 = pos1.size(), len2 = pos2.size();
        int minD = Integer.MAX_VALUE;
        for (i = 0, j = 0; i < len1 && j < len2; ) {
            minD = Math.min(minD, Math.abs(pos1.get(i) - pos2.get(j)));
            if (pos1.get(i) > pos2.get(j)) {
                j++;
            } else if (pos1.get(i) < pos2.get(j)) {
                i++;
            } else {
                if (len1 - i > len2 - j) {
                    i++;
                } else {
                    j++;
                }
            }
            if (minD == 0) return 0;
        }
        return minD;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");