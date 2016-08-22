public class Solution {
    public int missingNumber(int[] nums) {
        int i, j, tmp;
        boolean hasN = false;
        i = 0;
        while (i < nums.length) {
            if (nums[i] == nums.length) {
                hasN = true;
                i++;
            } else if (nums[i] == i) {
                i++;
            } else {
                j = nums[i];
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        if (!hasN) return nums.length;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == nums.length) return i;
        }
        return 0;
    }
}