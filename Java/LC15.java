public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i, j, k, n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for (i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            k = i + 1;
            j = n - 1;
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[k], nums[j]));
                    k++;
                    while (k < j && nums[k] == nums[k - 1]) k++;
                    j--;
                    while (j > k && nums[j] == nums[j + 1]) j--;
                } else if (sum < 0) {
                    k++;
                } else if (sum > 0) {
                    j--;
                }
            }
        }
        
        return ans;
    }
}