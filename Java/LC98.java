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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
    public boolean isValidBST(TreeNode root, int minVal, int maxVal, int cmp) {
        if (root == null) return true;
        if (((cmp & 2) != 0 && root.val <= minVal)
        || ((cmp & 1) != 0 && root.val >= maxVal)) return false;
        return isValidBST(root.left, minVal, root.val, cmp | 1) 
            && isValidBST(root.right, root.val, maxVal, cmp | 2);
    }
}