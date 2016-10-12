public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int l = 0, r = nums.length - 1;
        int[] ans = new int[nums.length];
        int cnt = 0;
        while (l <= r) {
            int calcL = calc(nums[l], a, b, c);
            int calcR = calc(nums[r], a, b, c);
            if (a > 0) {
                if (calcL < calcR) {
                    ans[cnt++] = calcR;
                    r--;
                } else {
                    ans[cnt++] = calcL;
                    l++;
                }
            } else {
                if (calcL < calcR) {
                    ans[cnt++] = calcL;
                    l++;
                } else {
                    ans[cnt++] = calcR;
                    r--;
                }
            }
        }
        if (a > 0) {
            for (int i = 0; i < ans.length / 2; i++) {
                int tmp = ans[i];
                ans[i] = ans[ans.length - i - 1];
                ans[ans.length - i - 1] = tmp;
            }
        }
        return ans;
    }
    private int calc(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}