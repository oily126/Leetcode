public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 1 << 30;
        int maxPrefix = 0;
        int[] prefix = new int[nums.length];
        for (int index = 30; index >= 0; index--) {
            Set<Integer> prefixSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                prefix[i] |= nums[i] & mask;
                if (prefixSet.contains((maxPrefix | mask) ^ (prefix[i]))) {
                    maxPrefix |= mask;
                    if (mask == 1) {
                        //System.out.println(prefix[i]+" "+nums[i]);
                    }
                }
                prefixSet.add(prefix[i]);
            }
            //System.out.println(prefixSet);
            mask >>= 1;
        }
        return maxPrefix;
    }
}