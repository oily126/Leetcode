public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (sArr[i] == '+' && sArr[i + 1] == '+') {
                sArr[i] = sArr[i + 1] = '-';
                ans.add(new String(sArr));
                sArr[i] = sArr[i + 1] = '+';
            }
        }
        return ans;
    }
}