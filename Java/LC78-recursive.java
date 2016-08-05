public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, list, 0, ans);
        return ans;
    }
    public void helper(int[] nums, List<Integer> list, 
        int index, List<List<Integer>> ans) {
        if (index >= nums.length) {
            ans.add(new ArrayList<Integer>(list));
        } else {
            helper(nums, list, index + 1, ans);
            list.add(nums[index]);
            helper(nums, list, index + 1, ans);
            list.remove(list.size() - 1);
        }
    }
}