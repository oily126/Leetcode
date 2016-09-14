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
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        int val = 0;
        if (root.val > target && root.left != null) {
            val = closestValue(root.left, target);
            if (Math.abs(ans - target) > Math.abs(val - target)) {
                ans = val;
            }
        }
        if (root.val < target && root.right != null) {
            val = closestValue(root.right, target);
            if (Math.abs(ans - target) > Math.abs(val - target)) {
                ans = val;
            }
        }
        return ans;
    }
}