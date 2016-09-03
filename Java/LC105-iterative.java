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
        Stack<TreeNode> s = new Stack<>();
        TreeNode root;
        int index = 0;
        if (preorder.length == 0) {
            return null;
        }
        root = new TreeNode(preorder[0]);
        s.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode ptr = s.peek();
            if (ptr.val != inorder[index]) {
                ptr.left = new TreeNode(preorder[i]);
                s.push(ptr.left);
            } else {
                while (!s.empty() && s.peek().val == inorder[index]) {
                    ptr = s.pop();
                    index++;
                }
                ptr.right = new TreeNode(preorder[i]);
                s.push(ptr.right);
            }
        }
        return root;
    }
}