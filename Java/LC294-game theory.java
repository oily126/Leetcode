public class Solution {
    public boolean canWin(String s) {
        int i, j;
        int len = 0, maxLen = 0;
        int ans = 0;
        List<Integer> lens = new ArrayList<>();
        for (i = 0; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == '+') {
                len++;
            } else {
                lens.add(len);
                maxLen = Math.max(maxLen, len);
                len = 0;
            }
        }
        int[] res = new int[maxLen + 1];
        Set<Integer> numbers = new HashSet<>();
        for (i = 2; i <= maxLen; i++) {
            numbers.clear();
            for (j = 0; j < i / 2; j++) {
                numbers.add(res[j] ^ res[i - 2 - j]);
            }
            for (j = 0; j < numbers.size(); j++) {
                if (!numbers.contains(j)) {
                    res[i] = j;
                    break;
                }
            }
            if (j == numbers.size()) res[i] = j;
        }
        //for (int r : res) System.out.println(r);
        for (int l : lens) {
            ans ^= res[l];
        }
        return ans != 0;
    }
}