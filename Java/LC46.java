public class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, 0);
        return ans;
    }
    public void helper(int[] nums, int index) {
        if (index > nums.length) {
            List<Integer> tmparr = new ArrayList<Integer>();
            for (int num : nums) tmparr.add(num);
            ans.add(tmparr);
        } else {
            int i, tmp;
            helper(nums, index + 1);
            for (i = index + 1; i < nums.length; i++) {
                tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                helper(nums, index + 1);
                tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
    }
}