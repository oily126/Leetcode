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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode nRoot = root;
        while (nRoot.left != null) nRoot = nRoot.left;
        helper(root, null);
        return nRoot;
    }
    private void helper(TreeNode root, TreeNode father) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = null;
        root.right = null;
        if (father != null) {
            father.left = root;
        }
        if (left != null) {
            helper(left, null);
        }
        helper(right, left);
        if (left != null) {
            left.right = root;
        }
        
    }
}