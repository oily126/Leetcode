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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null || root == null) return null;
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        boolean first = true;
        while (cur != null && cur != p) {
            if (cur.val == p.val) break;
            if (cur.val > p.val) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        s.push(cur);
        cur = null;
        while (s.size() > 0 || cur != null) {
            if (cur == null) {
                cur = s.pop();
                //System.out.println("null "+cur.val);
                if (first) first = false; else return cur;
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = null;
                }
            } else {
                //System.out.println("not null "+cur.val);
                s.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = null;
                }
            }
        }
        return null;
    }
}