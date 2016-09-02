public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> sumCounts = new HashMap<>();
        return dfs(nums, target, sumCounts);
    }
    private int dfs(int[] nums, int target, Map<Integer, Integer> sumCounts) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (sumCounts.containsKey(target)) {
            return sumCounts.get(target);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += dfs(nums, target - nums[i], sumCounts);
        }
        sumCounts.put(target, count);
        return count;
    }
}