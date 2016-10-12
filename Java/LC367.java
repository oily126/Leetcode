public class Solution {
    public boolean isPerfectSquare(int num) {
        int mid, st, ed;
        boolean ans = false;
        if (num <= 1 && num >= 0) return true;
        st = 2;
        ed = num;
        while (st < ed) {
            mid = st + (ed - st) / 2;
            if (num % mid == 0 && num / mid == mid) return true;
            if (num / mid >= mid) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return num % st == 0 && num / st == st;
    }
}