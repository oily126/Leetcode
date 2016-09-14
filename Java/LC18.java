public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int sum = 0;
        List<List<Integer>> ans = new ArrayList<>();
        int i, j, k, l;
        Arrays.sort(nums);
        for (i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            
                k = j + 1;
                l = nums.length - 1;
                while (k < l) {
                    sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                    while (k > j + 1 && k < l && nums[k] == nums[k - 1]) k++;
                    while (l < nums.length - 1 && k < l && nums[l] == nums[l + 1]) l--;
                }
            }
        }
        return ans;
    }
}