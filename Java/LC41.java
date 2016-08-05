public class Solution {
    public int firstMissingPositive(int[] nums) {
        int r, i = 0;
        
        r = nums.length - 1;
        while (r >= 0) {
            if (nums[r] <= 0 || nums[r] > nums.length
                || nums[r] == nums[nums[r] - 1]) {
                r--;
            } else {
                int tmp = nums[r];
                nums[r] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return i + 1;
    }
}