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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode dfs(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preL]);
        int len = 0;
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == preorder[preL]) {
                len = i - inL;
                root.left = dfs(preorder, preL + 1, preL + len, inorder, inL, i - 1);
                root.right = dfs(preorder, preL + len + 1, preR, inorder, i + 1, inR);
            }
        }
        return root;
    }
}