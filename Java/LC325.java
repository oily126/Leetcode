public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> first = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        first.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!first.containsKey(sum)) {
                first.put(sum, i);
            }
        }
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (first.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - first.get(sum - k));
            }
        }
        return maxLen;
    }
}