public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int i, j, k, len, cnt = 1;
        Arrays.sort(nums);
        ans.add(new ArrayList<Integer>());
        for (i = 0; i < nums.length; i++) {
            if (i >= nums.length - 1 || nums[i] != nums[i + 1]) {
                len = ans.size();
                for (j = 0; j < len; j++) {
                    List<Integer> arr = new ArrayList<Integer>(ans.get(j));
                    for (k = 1; k <= cnt; k++) {
                        arr.add(nums[i]);
                        ans.add(new ArrayList<Integer>(arr));
                    }
                }
                cnt = 1;
            } else cnt++;
        }
        return ans;
    }
}