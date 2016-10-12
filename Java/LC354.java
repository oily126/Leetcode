public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Comparator<int[]> sizeCmp = new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return a[0] - b[0];
                    return b[1] - a[1];
                }
            };
        Arrays.sort(envelopes, sizeCmp);
        //for (int[] e : envelopes) System.out.println(e[0] + " " + e[1]);
        int n = envelopes.length;
        int[] maxLen = new int[n];
        List<int[]> minSizes = new ArrayList<int[]>();
        int ans = envelopes.length > 0 ? 1 : 0;
        int minI = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int pos = binarySearch(minSizes, envelopes[i]);
            if (pos >= minSizes.size()) {
                minSizes.add(envelopes[i]);
            } else {
                minSizes.set(pos, envelopes[i]);
            }
        }
        return minSizes.size();
    }
    private int binarySearch(List<int[]> minSizes, int[] key) {
        int l = 0, r = minSizes.size() - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (minSizes.get(mid)[1] >= key[1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}