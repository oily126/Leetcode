public class Solution {
    public void nextPermutation(int[] nums) {
        int i, pos = -1;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        reverse(nums, pos + 1, nums.length - 1);
        if (pos >= 0) {
            for (i = pos + 1; i < nums.length; i++) {
                if (nums[i] > nums[pos]) {
                    swap(nums, i, pos);
                    break;
                }
            }
        }
    }
    private void reverse(int[] nums, int l, int r) {
        for (int i = l; i <= l + (r - l) / 2; i++) {
            swap(nums, i, r - i + l);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}