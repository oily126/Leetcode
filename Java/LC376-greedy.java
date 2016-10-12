public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int asc = 1, desc = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < 0) {
                desc = asc + 1;
            } else if (nums[i + 1] - nums[i] > 0) {
                asc = desc + 1;
            }
        }
        return Math.max(asc, desc);
    }
}