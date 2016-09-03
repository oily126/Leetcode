public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int[] cumulative = new int[nums.length + 1];
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> ans = new ArrayList<>(k);
        int kNumCount = 0;
        
        for (int num : nums) {
            int cnt = counts.getOrDefault(num, 0) + 1;
            counts.put(num, cnt);
            cumulative[cnt]++;
        }
        
        for (int i = cumulative.length - 1; i > 0; i--) {
            if (cumulative[i] >= k) {
                kNumCount = i;
                break;
            }
        }
        
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (e.getValue() > kNumCount) {
                ans.add(e.getKey());
            }
        }
        
        if (ans.size() == k) {
            return ans;
        }
        
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (e.getValue() == kNumCount) {
                ans.add(e.getKey());
                if (ans.size() == k) {
                    return ans;
                }
            }
        }
        
        return ans;
    }
}