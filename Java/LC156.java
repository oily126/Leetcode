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
        TreeNode prev, cur, prevRight, left;
        prev = null;
        cur = root;
        prevRight = null;
        while (cur != null) {
            left = cur.left;
            cur.left = prevRight;
            prevRight = cur.right;
            cur.right = prev;
            prev = cur;
            cur = left;
        }
        return prev;
    }
}