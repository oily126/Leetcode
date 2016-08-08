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
    public List<Integer> inorderTraversal(TreeNode root) {
        int i;
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode ptr = root;
        while (ptr != null) {
            s.add(ptr);
            ptr = ptr.left;
            while (ptr == null) {
                if (s.empty()) break;
                ptr = s.pop();
                ans.add(ptr.val);
                ptr = ptr.right;
            }
        }
        return ans;
    }
}