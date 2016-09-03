public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pairs = 
            new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
        int i;
        for (i = 0; i < nums.length; i++) {
            if (m.get(nums[i]) == null) {
                m.put(nums[i], 1);
            } else {
                m.put(nums[i], m.get(nums[i]) + 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            pairs.offer(entry);
            if (pairs.size() > k) {
                pairs.poll();
            }
        } 
        
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : pairs) {
            ans.add(entry.getKey());
        }
        return ans;
    }
}