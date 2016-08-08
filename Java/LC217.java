public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> m = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.contains(nums[i])) return true;
            m.add(nums[i]);
        }
        return false;
    }
}