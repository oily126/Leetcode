public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int i, j, len = triangle.size(), levelLen = 0;
        if (len == 0) return 0;
        List<Integer> sums = new ArrayList<Integer>(triangle.get(len - 1));
        levelLen = sums.size();
        for (i = len - 2; i >= 0; i--) {
            levelLen--;
            for (j = 0; j < levelLen; j++) {
                sums.set(j, Math.min(sums.get(j), sums.get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return sums.get(0);
    }
}