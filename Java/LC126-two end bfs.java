public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        List<String> buf = new ArrayList<>();
        Set<String>[] reached = new HashSet[2];
        Map<String, List<String>> next = new HashMap<>();
        int idx = 0;
        reached[0] = new HashSet<String>();
        reached[1] = new HashSet<String>();
        reached[0].add(beginWord);
        reached[1].add(endWord);
        wordList.remove(beginWord);
        wordList.remove(endWord);
        if (beginWord.equals(endWord)) {
            buf.add(beginWord);
            ans.add(buf);
            return ans;
        }
        next.put(beginWord, new ArrayList<String>());
        if (!twoWayBfs(reached, next, wordList)) return ans;
        buf.add(beginWord);
        findPath(beginWord, endWord, ans, buf, next);
        return ans;
    }
    
    private boolean twoWayBfs(Set<String>[] reached, Map<String, List<String>> next, Set<String> wordList) {
        int idx = 0;
        char tmpChar;
        String tmpWord;
        Set<String> toExplore = null;
        boolean found = false;
        while (!found && reached[idx].size() > 0) {
            toExplore = reached[idx];
            reached[idx] = new HashSet<String>();
            for (String wordStr : toExplore) {
                char[] word = wordStr.toCharArray();
                //System.out.println("from "+wordStr);
                for (int i = 0; i < word.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (word[i] != ch) {
                            tmpChar = word[i];
                            word[i] = ch;
                            tmpWord = new String(word);
                            if (reached[idx].contains(tmpWord)) {
                                if (idx == 0) {
                                    next.get(wordStr).add(tmpWord);
                                } else {
                                    next.get(tmpWord).add(wordStr);
                                }
                            }
                            if (reached[1 - idx].contains(tmpWord)) {
                                found = true;
                                //System.out.println("found");
                                if (idx == 0) {
                                    next.get(wordStr).add(tmpWord);
                                } else {
                                    next.get(tmpWord).add(wordStr);
                                }
                            } else {
                                if (!found && wordList.contains(tmpWord)) {
                                    wordList.remove(tmpWord);
                                    next.put(tmpWord, new ArrayList<String>());
                                    reached[idx].add(tmpWord);
                                    if (idx == 0) {
                                        next.get(wordStr).add(tmpWord);
                                    } else {
                                        next.get(tmpWord).add(wordStr);
                                    }
                                    //System.out.println("added "+tmpWord);
                                }
                            }
                            word[i] = tmpChar;    
                        }
                    }
                }
            }
            idx = 1 - idx;
        }
        return found;
    }
    
    private void findPath(String beginWord, String endWord, List<List<String>> ans, 
        List<String> buf, Map<String, List<String>> next) {
        
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<String>(buf));
            return;
        }
        for (String word : next.get(beginWord)) {
            buf.add(word);
            //System.out.println("path:"+beginWord + "->" + word);
            findPath(word, endWord, ans, buf, next);
            buf.remove(buf.size() - 1);
        }
    }
}