/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        int minIndex = bfs(root, nodes);
        
        List<List<Integer>> ans = new ArrayList<>(nodes.size());
        for (int i = 0; i < nodes.size(); i++) ans.add(new ArrayList<>());
        for (Integer node : nodes.keySet()) {
            ans.set(node - minIndex, nodes.get(node));
        }
        return ans;
    }
    private int bfs(TreeNode root, Map<Integer, List<Integer>> nodes) {
        if (root == null) return 0;
        Queue<TreeNode> next = new LinkedList<>();
        Queue<Integer> indexes = new LinkedList<>();
        int minIndex = 0;
        next.offer(root);
        indexes.offer(0);
        while (next.size() > 0) {
            for (int size = next.size() - 1; size >= 0; size--) {
                TreeNode node = next.poll();
                int index = indexes.poll();
                if (!nodes.containsKey(index)) {
                    nodes.put(index, new ArrayList<>());
                }
                nodes.get(index).add(node.val);
                if (node.left != null) {
                    next.offer(node.left);
                    indexes.offer(index - 1);
                    minIndex = Math.min(minIndex, index - 1);
                }
                if (node.right != null) {
                    next.offer(node.right);
                    indexes.offer(index + 1);
                }
            }
        }
        return minIndex;
    }
}