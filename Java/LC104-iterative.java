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
    public int maxDepth(TreeNode root) {
        int maxDep = 0;
        List<TreeNode> next = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        if (root != null) {
            next.add(root);
        }
        while (next.size() > 0) {
            maxDep++;
            cur = next;
            next = new ArrayList<>();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
        }
        return maxDep;
    }
}