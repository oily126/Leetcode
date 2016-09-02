public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int i, j, len = 0, last, distance = 1;
        char ch;
        List<String> visited = new ArrayList<>();
        
        if (beginWord.equals(endWord)) {
            return 0;
        }
        visited.add(beginWord);
        wordList.remove(beginWord);
        while (len < visited.size()) {
            last = len;
            len = visited.size();
            distance++;
            for (i = last; i < len; i++) {
                char[] str = visited.get(i).toCharArray(); 
                for (j = 0; j < str.length; j++) {
                    char tmp = str[j];
                    for (ch = 'a'; ch <= 'z'; ch++) {
                        if (tmp != ch) {
                            String s;
                            str[j] = ch;
                            s = new String(str);
                            if (s.equals(endWord)) {
                                return distance;
                            }
                            if (wordList.contains(s)) {
                                visited.add(s);
                                wordList.remove(s);
                            }
                        }
                    }
                    str[j] = tmp;
                }
            }
        }
        return 0;
    }
}