public class Solution {
    public int splitArray(int[] nums, int m) {
        long[] sum = new long[nums.length];
        long l, r, mid;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum[i] = nums[i];
            } else {
                sum[i] += sum[i - 1] + nums[i];
            }
        }
        l = 0;
        r = sum[i - 1];
        int t = 0;
        long last, maxNum = 0;
        long ans = Integer.MAX_VALUE;
        while (l <= r) {
            mid = l + (r - l) / 2;
            last = 0;
            t = 0;
            maxNum = 0;
            for (i = 0; i < nums.length; i++) {
                if (i >= nums.length - 1 || sum[i] - last > mid || sum[i + 1] - last > mid) {
                    maxNum = Math.max(maxNum, sum[i] - last);
                    last = sum[i];
                    System.out.println("last:"+last);
                    t++;
                }
            }
            //System.out.println(l+" "+r+" "+t);
            if (t < m) {
                r = mid - 1;
            } else if (t > m) {
                l = mid + 1;
            } else {
                ans = Math.min(ans, maxNum);
                if (maxNum > mid) l = mid + 1; else r = mid - 1;
            }
        }
        return (int) ans;
    }
}