public class Solution {
    public int[] singleNumber(int[] nums) {
        int a_xor_b = 0, other, diff, a = 0, b = 0;
        for (int num : nums) {
            a_xor_b ^= num;
        }
        // choose right most bit from a xor b as diff
        diff = a_xor_b & ~(a_xor_b - 1);
        for (int num : nums) {
            // divide nums into 2 groups: 1 group with a 
            // and 1 group with b
            other = num & diff;
            if (other == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}