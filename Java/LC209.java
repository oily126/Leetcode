public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l, r, sum = 0, ans = Integer.MAX_VALUE;
        l = 0;
        r = 0;
        while (r < nums.length) {
            sum += nums[r];
            if (sum >= s) {
                while (l <= r && sum - nums[l] >= s) {
                    sum -= nums[l++];
                }
                if (l <= r) ans = Math.min(r - l + 1, ans);
            }
            r++;
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}