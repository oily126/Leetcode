public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i;
        int start = 0, end = 0;
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] != nums[end] + 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[start]);
                if (start != end) {
                    sb.append("->").append(nums[end]);
                }
                ans.add(sb.toString());
                start = end = i;
            } else {
                end++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[start]);
        if (start != end) {
            sb.append("->").append(nums[end]);
        }
        ans.add(sb.toString());
        return ans;        
    }
}