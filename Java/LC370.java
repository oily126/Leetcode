public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int i = 0; i < updates.length; i++) {
            nums[updates[i][0]] += updates[i][2];
            if (updates[i][1] < length - 1) nums[updates[i][1] + 1] -= updates[i][2];
        }
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}