public class Solution {
    private static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>(), lastList;
        if (digits.length() == 0) {
            return ans;
        }
        ans.add("");
        for (int j = 0; j < digits.length(); j++) {
            lastList = ans;
            ans = new ArrayList<>();
            for (String s : lastList) {
                for (int i = 0; i < letters[digits.charAt(j) - '0'].length(); i++) {
                    ans.add(s + letters[digits.charAt(j) - '0'].charAt(i));
                }
            }
        }
        return ans;
    }
}