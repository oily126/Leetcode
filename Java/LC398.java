public class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int index = -1, cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rand.nextInt(cnt++) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */