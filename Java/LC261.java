public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0 && n == 1) return true;
        boolean[] used = new boolean[n];
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        for (int[] edge : edges) {
            if (!edgesMap.containsKey(edge[0])) {
                edgesMap.put(edge[0], new ArrayList<>());
            }
            edgesMap.get(edge[0]).add(edge[1]);
            if (!edgesMap.containsKey(edge[1])) {
                edgesMap.put(edge[1], new ArrayList<>());
            }
            edgesMap.get(edge[1]).add(edge[0]);
        }
        if (edgesMap.size() != n) return false;
        return dfs(-1, 0, used, edgesMap) == n;
    }
    private int dfs(int from, int node, boolean[] used, Map<Integer, List<Integer>> edgesMap) {
        int cnt = 1;
        used[node] = true;
        for (Integer next : edgesMap.get(node)) {
            if (next == from) continue;
            if (used[next]) return -1;
            int nextLen = dfs(node, next, used, edgesMap);
            if (nextLen < 0) return nextLen;
            cnt += nextLen;
        }
        return cnt;
    }
}
