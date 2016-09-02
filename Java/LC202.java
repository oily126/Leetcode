public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> sums = new HashSet<>();
        int i;
        while (n != 1 && !sums.contains(n)) {
            sums.add(n);
            i = n;
            n = 0;
            while (i != 0) {
                n += (i % 10) * (i % 10);
                i /= 10;
            }
        }
        return n == 1;
    }
}