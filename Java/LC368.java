public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] subset = new int[nums.length];
        int[] from = new int[nums.length];
        int i, j, max_pos = 0, n = nums.length;
        List<Integer> ansArr = new ArrayList<>();
        
        if (n == 0) return ansArr;
        Arrays.sort(nums);
        for (i = 0; i < n; i++) {
            subset[i] = 1;
            from[i] = i;
        }
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (subset[j] + 1 > subset[i] && nums[i] % nums[j] == 0) {
                    subset[i] = subset[j] + 1;
                    from[i] = j;
                    if (subset[i] > subset[max_pos]) max_pos = i;
                }
            }
        }
        i = max_pos;
        while (from[i] != i) {
            ansArr.add(nums[i]);
            i = from[i];
        }
        ansArr.add(nums[i]);
        return ansArr;
    }
}