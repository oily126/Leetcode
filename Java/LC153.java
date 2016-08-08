public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[l] < nums[r]) {
                return nums[l];
            } else {
                if (nums[mid] <= nums[r]) {
                    r = mid;
                    l++;
                } else {
                    if (nums[mid] >= nums[l]) {
                        l = mid + 1;
                    }
                }
            }
        }
        if (l < nums.length) return nums[l]; else return -1;
    }
}