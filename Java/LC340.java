public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        
        Map<Character, Integer> nums = new HashMap<>();
        int i, start = 0, cnt = 0, maxLen = 0;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!nums.containsKey(ch)) {
                nums.put(ch, 1);
                cnt++;
                if (cnt > k) {
                    while (cnt > k && start < i) {
                        int num = nums.get(s.charAt(start));
                        if (num <= 1) {
                            nums.remove(s.charAt(start));
                            cnt--;
                        } else {
                            nums.put(s.charAt(start), num - 1);
                        }
                        start++;
                    }
                }
                maxLen = Math.max(i - start + 1, maxLen);
            } else {
                nums.put(ch, nums.get(ch) + 1);
                maxLen = Math.max(i - start + 1, maxLen);
            }
        }
        return maxLen;
    }
}