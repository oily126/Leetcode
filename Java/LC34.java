public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l, r, mid;
        int lans = -1, rans = -1;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    r = mid - 1;
                } else {
                    lans = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    rans = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[] { lans, rans };
    }
}