public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int l, r, cnt = 0;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < target) {
                    cnt += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return cnt;
    }
}