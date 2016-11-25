public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (seqs.length == 0) return false;
        int[] pos = new int[org.length + 1];
        for (int i = 0; i < org.length; i++) {
            pos[org[i]] = i;
        }
        int nodeLeft = org.length - 1;
        boolean[] visited = new boolean[org.length + 1];
        for (int[] nodes : seqs) {
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] <= 0 || nodes[i] > org.length) return false;
                if (i == 0) continue;
                if (pos[nodes[i - 1]] >= pos[nodes[i]]) return false;
                if (!visited[nodes[i - 1]] && pos[nodes[i - 1]] + 1 == pos[nodes[i]]) {
                    visited[nodes[i - 1]] = true;
                    nodeLeft--;
                }
            }
        }
        return nodeLeft == 0;
    }
}