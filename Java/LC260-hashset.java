public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num)) {
                s.remove(num);
            } else {
                s.add(num);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (Integer num : s) {
            ans[i++] = num;
        }
        return ans;
    }
}