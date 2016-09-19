public class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        dfs(0, 0, n, sb, ans);
        return ans;
    }
    private void dfs(int l, int r, int n, StringBuilder sb, List<String> ans) {
        if (l == n && r == n) {
            ans.add(sb.toString());
            return;
        }
        if (l > n || r > n) {
            return;
        }
        if (l < n) {
            sb.append('(');
            dfs(l + 1, r, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        if (l > r) {
            sb.append(')');
            dfs(l, r + 1, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
}