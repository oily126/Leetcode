public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        List<String> anagrams;
        List<List<String>> ans = new ArrayList<>();
        int i;
        String s;
        
        for (i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            s = String.valueOf(arr);
            anagrams = m.get(s);
            if (anagrams == null) {
                anagrams = new ArrayList<String>();
                anagrams.add(strs[i]);
                m.put(s, anagrams);
            } else {
                anagrams.add(strs[i]);
            }
        }
        
        for (List<String> iter : m.values()) {
            ans.add(iter);
        }
        return ans;
    }
}