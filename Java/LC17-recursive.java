public class Solution {
    private static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, sb, ans);
        return ans;
    }
    private void helper(String digits, int index, StringBuilder sb, List<String> ans) {
        if (index >= digits.length()) {
            if (index > 0) ans.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        if (ch <= '1' || ch > '9') {
            return;
        }
        for (int i = 0; i < letters[ch - '0'].length(); i++) {
            sb.append(letters[ch - '0'].charAt(i));
            helper(digits, index + 1, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
}