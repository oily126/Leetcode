public class Solution {
    public List<String> generateParenthesis(int n) {
        Queue<String> next = new LinkedList<>(); 
        Set<String> pairs = new HashSet<>();
        int i, j, k, size = 0;
        
        next.offer("");
        for (i = 0; i < n; i++) {
            pairs.clear();
            size = next.size();
            for (j = 0; j < size; j++) {
                String s = next.poll();
                for (k = 0; k <= s.length(); k++) {
                    String newS = s.substring(0, k) + "()" + s.substring(k);
                    if (pairs.add(newS)) {
                        next.offer(newS);
                    }
                }
            }
        }
        return new ArrayList<String>(pairs);
    }
}