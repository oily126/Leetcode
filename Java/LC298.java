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
    public int longestConsecutive(TreeNode root) {
        int[] maxLen = new int[1];
        longestConsecutive(root, maxLen);
        return maxLen[0];
    }
    private int longestConsecutive(TreeNode root, int[] maxLen) {
        if (root == null) return 0;
        int ans = 1;
        int leftVal = longestConsecutive(root.left, maxLen);
        int rightVal = longestConsecutive(root.right, maxLen);
        if (root.left == null || root.left.val == root.val + 1) ans = Math.max(ans, leftVal + 1);
        if (root.right == null || root.right.val == root.val + 1) ans = Math.max(ans, rightVal + 1);
        maxLen[0] = Math.max(maxLen[0], ans);
        return ans;
    }
}