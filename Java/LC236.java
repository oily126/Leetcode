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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> s = new Stack<>();
        Map<TreeNode, TreeNode> father = new HashMap<>();
        Set<TreeNode> path = new HashSet<>();
        father.put(root, null);
        while (!s.empty() || root != null) {
            if (root != null) {
                s.add(root);
                if (root.left != null) {
                    father.put(root.left, root);
                }
                if (root.right != null) {
                    father.put(root.right, root);
                }
                root = root.left;
            } else {
                root = s.pop();
                root = root.right;
            }
        }
        path.add(p);
        TreeNode tmp = father.get(p);
        while (tmp != null) {
            path.add(tmp);
            p = tmp;
            tmp = father.get(p);
        }
        tmp = q;
        while (tmp != null) {
            if (path.contains(tmp)) return tmp;
            q = tmp;
            tmp = father.get(q);
        }
        return null;
    }
}