public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        int i;
        List<List<String>> ans = new ArrayList<>(); 
        Map<String, Set<String>> prefixs = new HashMap<>();
        
        if (words == null || words.length == 0) return ans;
        List<String> buf = new ArrayList<>();
        
        buildPrefixs(prefixs, words);
        getWordSquares(prefixs, buf, ans, 0, words[0].length());
        return ans;
    }
    private void getWordSquares(Map<String, Set<String>> prefixs, List<String> buf, List<List<String>> ans, 
        int x, int n) {
        if (x >= n) {
            ans.add(new ArrayList<String>(buf));
            //System.out.println("-------------------found");
        } else {
            StringBuilder curCol = new StringBuilder();
            for (int i = 0; i < x; i++) {
                curCol.append(buf.get(i).charAt(x));
            }
            Set<String> curPrefixs = prefixs.get(curCol.toString());
            if (curPrefixs == null) return;
            for (String word : curPrefixs) {
                buf.add(word);
                getWordSquares(prefixs, buf, ans, x + 1, n);
                buf.remove(buf.size() - 1);
            }
        }
    }
    private void buildPrefixs(Map<String, Set<String>> prefixs, String[] words) {
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String sub = word.substring(0, i);
                if (!prefixs.containsKey(sub)) {
                    prefixs.put(sub, new HashSet<>());
                }
                prefixs.get(sub).add(word);
            }
        }
        //System.out.println(prefixs);
    }
}
