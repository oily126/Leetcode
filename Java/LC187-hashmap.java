public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet<>();
        Set<String> dna = new HashSet<>();
        int i;
        int dnaLen = 10;
        String sub;
        for (i = 0; i < s.length() - dnaLen + 1; i++) {
            sub = s.substring(i, i + dnaLen);
            if (!dna.contains(sub)) {
                dna.add(sub);
            } else {
                ans.add(sub);
            }
        }
        List<String> ansArr = new ArrayList<>(ans.size());
        for (String tmp : ans) {
            ansArr.add(tmp);
        }
        return ansArr;
        
    }
}