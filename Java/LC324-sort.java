public class Solution {
    public void wiggleSort(int[] nums) {
        int i, j, k;
        int[] newNums = new int[nums.length];
        Arrays.sort(nums);
        for (i = 0, j = nums.length / 2 + nums.length % 2 - 1; i * 2 < nums.length; i++, j--) {
            newNums[i * 2] = nums[j];
        }
        
        for (j = i, i -= nums.length % 2; i > 0 && j < nums.length; i--, j++) {
            newNums[i * 2 - 1] = nums[j];
        }
        for (i = 0; i < nums.length; i++) nums[i] = newNums[i];
    }
}