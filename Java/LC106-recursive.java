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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder, int inL, 
        int inR, int postL, int postR) {
        
        if (postR < postL) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postR]);
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(inorder, postorder, inL, i - 1, postL,  postL + i - 1 - inL);
                root.right = buildTree(inorder, postorder, i + 1, inR, postR - inR + i, postR - 1);
            }
        }
        
        return root;
    }
}