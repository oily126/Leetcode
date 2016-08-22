public class Solution {
    int[] nums;
    int[] origin;
    Random r;
    public Solution(int[] nums) {
        this.nums = nums.clone();
        origin = nums.clone();
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for (int i = 0; i < nums.length; i++) nums[i] = origin[i];
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int change = r.nextInt(i + 1), tmp;
            tmp = nums[i];
            nums[i] = nums[change];
            nums[change] = tmp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */