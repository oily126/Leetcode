public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        boolean asc = false, desc = false;
        int len = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {
                if (asc) {
                    len++;
                }
                asc = false;
                desc = true;
            } else if (nums[i + 1] - nums[i] > 0) {
                if (desc) {
                    len++;
                }
                asc = true;
                desc = false;
            }
        }
        return len + (nums[nums.length - 1] == nums[nums.length - 2] ? 0 : 1);
    }
}