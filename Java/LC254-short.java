public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> buf = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 1) return ans;
        helper(n, 2, buf, ans);
        return ans;
    }
    private void helper(int cur, int start, List<Integer> buf, 
        List<List<Integer>> ans) {
        if (cur == 1) {
            if (buf.size() > 1) ans.add(new ArrayList<>(buf));
        }
        for (int i = start; i <= Math.sqrt(cur); i++) {
            if (cur % i == 0) {
                buf.add(i);
                helper(cur / i, i, buf, ans);
                buf.remove(buf.size() - 1);
            }
        }
        if (cur >= start) {
            buf.add(cur);
            helper(1, cur, buf, ans);
            buf.remove(buf.size() - 1);
        }
    }
}