public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k * 2, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.intValue() - b.intValue();
            }
        });
        int i;
        for (i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}