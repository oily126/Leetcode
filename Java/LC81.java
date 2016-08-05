public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        return search(nums, target, 0, nums.length - 1);
    }
    public boolean search(int[] nums, int target, int l, int r) {
        int mid;
        
        if (l > r) return false;
        if (nums[l] == target || nums[r] == target) return true;
        
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return true;
            if (nums[l] == nums[r] && nums[l] == nums[mid]) {
                return search(nums, target, l + 1, mid - 1) 
                    || search(nums, target, mid + 1, r - 1);
            }
            if (nums[l] < nums[r]) {
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] < nums[l]) {
                    if (nums[mid] > target) r = mid - 1;
                    else if (nums[l] <= target) r = mid - 1;
                    else l = mid + 1;
                } else {
                    if (nums[mid] < target) l = mid + 1;
                    else if (nums[l] <= target) r = mid - 1;
                    else l = mid + 1;
                }
            }
        }
        return nums[l] == target;
    }
}