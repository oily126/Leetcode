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
    public int kthSmallest(TreeNode root, int k) {
        int cnt = countNode(root.left);
        if (cnt + 1 == k) return root.val;
        if (cnt >= k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - cnt - 1);
        }
    }
    public int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + countNode(root.left) + countNode(root.right);
        }
    }
}