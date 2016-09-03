public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> ans = new ArrayList<>(k);
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            if (buckets[e.getValue()] == null) {
                buckets[e.getValue()] = new ArrayList<Integer>();
            }
            buckets[e.getValue()].add(e.getKey());
        }
        
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] != null && k > 0) {
                for (Integer num : buckets[i]) {
                    k--;
                    ans.add(num);
                }
            }
        }
        
        return ans;
    }
}