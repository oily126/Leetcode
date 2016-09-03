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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        TreeNode ptr = root;
        if (root == null) {
            return preOrder;
        } else {
            preOrder.add(root.val);
            s.push(root);
        }
        
        ptr = root;
        while (!s.empty() || ptr != null) {
            ptr = ptr.left;
            if (ptr != null) {
                preOrder.add(ptr.val);
                s.push(ptr);
            }
            while (ptr == null && !s.empty()) {
                ptr = s.pop().right;
                if (ptr != null) {
                    preOrder.add(ptr.val);
                    s.push(ptr);
                }
            }
        }
        
        return preOrder;
    }
}