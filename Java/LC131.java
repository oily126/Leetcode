public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> buf = new ArrayList<>();
        partition(s, 0, buf, ans);
        return ans;
    }
    public void partition(String s, int index,
        List<String> buf, List<List<String>> ans) {
        if (index >= s.length()) {
            ans.add(new ArrayList<String>(buf));
        } else {
            for (int i = index + 1; i <= s.length(); i++) {
                String tmp = s.substring(index, i);
                if (isPalindrom(tmp)) {
                    buf.add(tmp);
                    partition(s, i, buf, ans);
                    buf.remove(buf.size() - 1);
                }
            }
        }
    }
    public boolean isPalindrom(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}