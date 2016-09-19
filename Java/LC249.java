public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, Integer> m = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for (String s : strings) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            if (e.getValue() > 0) {
                char[] sArr = e.getKey().toCharArray();
                List<String> tmp = new ArrayList<>();
                for (int j = 0; j < e.getValue(); j++) {
                    tmp.add(e.getKey());
                }
                m.put(e.getKey(), 0);
                
                for (int j = 1; j < 26; j++) {
                    for (int i = 0; i < sArr.length; i++) {
                        sArr[i] = (char)((sArr[i] - 'a' + 1) % 26 + 'a');
                    }
                    String newS = new String(sArr);
                    if (m.getOrDefault(newS, 0).intValue() > 0) {
                        for (int k = 0; k < m.get(newS); k++) {
                            tmp.add(newS);
                        }
                        m.put(newS, 0);
                    }
                }
                ans.add(tmp);
            }
        }
        return ans;
    }
}