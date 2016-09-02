public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int i, j;
        int[] counts = new int[target + 1];
        Arrays.sort(nums);
        counts[0] = 1;
        for (j = 1; j <= target; j++) {
            for (i = 0; i < nums.length; i++) {
                if (j < nums[i]) break;
                counts[j] += counts[j - nums[i]];
            }
        }
        return counts[target];
    }
}