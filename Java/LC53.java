public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        
        int i, curSum = 0, ans = Integer.MIN_VALUE;
        for (i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > ans) ans = curSum;
            if (curSum < 0) curSum = 0;
        }
        return ans;
    }
}