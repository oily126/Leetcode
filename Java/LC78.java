public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int i, j, n = 0;
        
        ans.add(new ArrayList<Integer>());
        for (i = 0; i < nums.length; i++) {
            n = ans.size();
            for (j = 0; j < n; j++) {
                List<Integer> tmp = new ArrayList<Integer>(ans.get(j));
                tmp.add(nums[i]);
                ans.add(tmp);
            }
        }
        return ans;
    }
}