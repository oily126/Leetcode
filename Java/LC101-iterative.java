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
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> leftHalf = new Stack<>();
        Stack<TreeNode> rightHalf = new Stack<>();
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            leftHalf.push(root.left);
        }
        if (root.right != null) {
            rightHalf.push(root.right);
        }
        while (!leftHalf.empty() && !rightHalf.empty()) {
            TreeNode ptrL = leftHalf.peek();
            TreeNode ptrR = rightHalf.peek();
            leftHalf.pop();
            rightHalf.pop();
            if (ptrL.val != ptrR.val) {
                return false;
            }
            if ((ptrL.left == null || ptrR.right == null) && ptrL.left != ptrR.right) {
                return false;
            }
            if (ptrL.left != null && ptrR.right != null) {
                leftHalf.push(ptrL.left);
                rightHalf.push(ptrR.right);
            }
            
            if ((ptrR.left == null || ptrL.right == null) && ptrR.left != ptrL.right) {
                return false;
            }
            if (ptrR.left != null && ptrL.right != null) {
                leftHalf.push(ptrL.right);
                rightHalf.push(ptrR.left);
            }
        }
        return leftHalf.empty() && rightHalf.empty();
    }
}