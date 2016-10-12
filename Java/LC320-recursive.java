public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        dfs(word, ans, 0, 0, "");
        return ans;
    }
    private void dfs(String word, List<String> ans, int cnt, int idx, String cur) {
        if (idx == word.length()) {
            ans.add(cur + ((cnt > 0) ? cnt : ""));
        } else {
            dfs(word, ans, cnt + 1, idx + 1, cur);
            dfs(word, ans, 0, idx + 1, cur + ((cnt > 0) ? cnt : "") + word.charAt(idx));
        }
    }
}