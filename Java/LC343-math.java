public class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            switch (n) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                default:
                    break;
            }
            return 0;
        } else {
            int p = 1;
            while (n > 4) {
                n -= 3;
                p *= 3;
            }
            p *= n;
            return p;
        }
    }
}