public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> s = new TreeSet<>();
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i > k) {
                s.remove(nums[i - k - 1]);
            }
            Integer h = s.higher(nums[i] - t - 1);
            Integer l = s.lower(nums[i] + t + 1);
            if ((h != null && h.intValue() - nums[i] <= t) 
                || (l != null && nums[i] - l.intValue() <= t)) { 
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}