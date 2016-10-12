public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> buf = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 1) return ans;
        helper(n, n, 2, buf, ans);
        return ans;
    }
    private void helper(int n, int cur, int start, List<Integer> buf, 
        List<List<Integer>> ans) {
        if (cur == 1) {
            ans.add(new ArrayList<>(buf));
        }
        if (cur < start) return;
        if (cur >= start && cur != n) {
            buf.add(cur);
            ans.add(new ArrayList<>(buf));
            buf.remove(buf.size() - 1);
        }
        for (int i = start; i <= Math.sqrt(cur); i++) {
            int m = cur;
            while (m / i > 0 && m % i == 0) {
                m /= i;
                buf.add(i);
                helper(n, m, i + 1, buf, ans);
            }
            while (buf.size() > 0 && buf.get(buf.size() - 1) == i) buf.remove(buf.size() - 1);
        }
    }
}