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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        helper(root, preOrder);
        return preOrder;
    }
    public void helper(TreeNode root, List<Integer> preOrder) {
        if (root == null) {
            return;
        }
        preOrder.add(root.val);
        helper(root.left, preOrder);
        helper(root.right, preOrder);
    }
}