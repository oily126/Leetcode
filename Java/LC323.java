public class Solution {
    public int countComponents(int n, int[][] edges) {
        int i, cnt = 0;
        int[] link = new int[n];
        for (i = 0; i < n; i++) link[i] = i;
        for (i = 0; i < edges.length; i++) {
            int a = find(link, edges[i][0]);
            int b = find(link, edges[i][1]);
            if (a > b) {
                link[b] = a;
            } else {
                link[a] = b;
            }
        }
        for (i = 0; i < n; i++) {
            if (find(link, i) >= 0) {
                link[find(link, i)] = -1;
                cnt++;
            }
        }
        return cnt;
    }
    private int find(int[] link, int i) {
        if (i < 0 || link[i] == i) return i;
        link[i] = find(link, link[i]);
        return link[i];
    }
}