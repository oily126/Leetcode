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
    public int countUnivalSubtrees(TreeNode root) {
        return Math.abs(helper(root));
    }
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int lval = 0, rval = 0;
        if (root.left != null) {
            lval = helper(root.left);
            if (root.val != root.left.val) {
                lval = -Math.abs(lval);
            }
        }
        if (root.right != null) {
            rval = helper(root.right);
            if (root.val != root.right.val) {
                rval = -Math.abs(rval);
            }
        }
        //System.out.println(lval+" "+rval);
        if (lval >= 0 && rval >= 0) return lval + rval + 1;
        
        return -(Math.abs(lval) + Math.abs(rval));
    }
}