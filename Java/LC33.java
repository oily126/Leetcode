public class Solution {
    public int search(int[] nums, int target) {
        int l, r, mid;
        
        l = 0;
        r = nums.length - 1;
        
        while (l <= r) {
            mid = l + (r - l) / 2;
            //System.out.println(l+" "+r+" "+mid);
            //System.out.println(nums[l]+"-"+nums[r]+"-"+nums[mid]);
            
            if (nums[mid] == target) return mid;
            
            if (nums[l] <= nums[r]) {
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
        
        if (l == r && nums[l] == target) return l;
        return -1;
    }
}