public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(ans, seq, nums, 0, used);
        return ans;
    }
    public void helper(List<List<Integer>> ans, List<Integer> seq,
        int[] nums, int selected, boolean[] used) {
        if (selected >= nums.length) {
            ans.add(new ArrayList<Integer>(seq));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                    used[i] = true;
                    seq.add(nums[i]);
                    helper(ans, seq, nums, selected + 1, used);
                    used[i] = false;
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}