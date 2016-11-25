public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int begin = 0;
        int[] nums = new int[256];
        int cnt = 0;
        int maxLen = 0;
        for (int end = 0; end  s.length(); end++) {
            char ch = s.charAt(end);
            if (nums[ch] == 0) {
                cnt++;
            }
            nums[ch]++;
            if (cnt  2) {
                while (begin  end && nums[s.charAt(begin)]  0) {
                    if ((--nums[s.charAt(begin)]) == 0) {
                        cnt--;
                        begin++;
                        break;
                    }
                    begin++;
                }
            }
            maxLen = Math.max(end - begin + 1, maxLen);
        }
        return maxLen;
    }
}