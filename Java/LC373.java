public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    int sum1 = nums1[a[0]] + nums2[a[1]], sum2 = nums1[b[0]] + nums2[b[1]];
                    if (sum1 == sum2) return 0;
                    return (sum1 > sum2) ? 1 : -1;
                }
            });
        if (nums1.length == 0 || nums2.length == 0) return ans;
        pq.add(new int[] {0, 0});
        while (k-- > 0 && pq.size() > 0) {
            int[] index = pq.poll();
            ans.add(new int[] {nums1[index[0]], nums2[index[1]]});
            index[0] += 1;
            if (index[0] < nums1.length) pq.offer(Arrays.copyOf(index, 2));
            index[0] -= 1;
            if (index[0] == 0 && index[1] < nums2.length - 1) {
                index[1] += 1;
                pq.offer(Arrays.copyOf(index, 2));
            }
        }
        return ans;
    }
}