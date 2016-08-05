public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] arr = new int[candidates.length];
        Arrays.sort(candidates);
        return helper(0, candidates, target, arr, 0);
    }
    public List<List<Integer>> helper(int index, int[] candidates, int target, 
        int[] arr, int len) {
        int i, next;
        if (target == 0) {
            List<List<Integer>> tmp = new ArrayList<>();
            List<Integer> tmp1 = new ArrayList<>();
            for (i = 0; i < len; i++) tmp1.add(candidates[arr[i]]);
            tmp.add(tmp1);
            return tmp;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        if (index >= candidates.length || target < candidates[index])
            return new ArrayList<List<Integer>>();
        for (i = index; i < candidates.length; i++)  {
            if (candidates[index] != candidates[i]) break;
        }
        next = i;
        ans.addAll(helper(next, candidates, target, arr, len));
        
        for (i = index; i < next; i++) {
            if (target >= candidates[index]) {
                target -= candidates[index];
                arr[len++] = i;
                ans.addAll(helper(next, candidates, target, arr, len));
            } else break;
        }
        return ans;
    }
}