public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int l = lower - 1, r;
        String s = null;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            s = findMissing(l, nums[i]);
            if (s != null) ans.add(s);
            l = nums[i];
        }
        s = findMissing(l, upper + 1);
        if (s != null) ans.add(s);
        return ans;
    }
    private String findMissing(int l, int r) {
        if (l + 1 <= r - 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(l + 1);
            if (r - 1 > l + 1) {
                sb.append("->").append((r - 1));
            }
            return sb.toString();
        }
        return null;
    }
}