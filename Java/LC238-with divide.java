public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i, cnt = 0;
        int product = 1;
        int[] ans = new int[nums.length];
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) cnt++;
            if (cnt > 1) break;
        }
        if (cnt == 1) {
            for (i = 0; i < nums.length; i++) {
                if (nums[i] != 0) product *= nums[i];
                else cnt = i;
            }
            ans[cnt] = product;
        } else if (cnt == 0) {
            for (i = 0; i < nums.length; i++) {
                product *= nums[i];
            }
            for (i = 0; i < nums.length; i++) {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}