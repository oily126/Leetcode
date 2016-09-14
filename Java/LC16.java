public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int i, j, k;
        int sum = 0, closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (i = 0; i < nums.length - 1; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closest;
    }
}