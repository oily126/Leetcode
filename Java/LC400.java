public class Solution {
    public int findNthDigit(int n) {
        long len = 1, start = 1, end = 10;
        while ((end - start) * len < n) {
            n -= (end - start) * len;
            end *= 10;
            start *= 10;
            len++;
        }
        n--;
        start += n / len;
        n %= len;
        return (new Long(start)).toString().charAt(n) - '0';
    }
}