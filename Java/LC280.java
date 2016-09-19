public class Solution {
    public void wiggleSort(int[] nums) {
        int i;
        for (i = 1; i < nums.length; i += 2) {
            if (nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}