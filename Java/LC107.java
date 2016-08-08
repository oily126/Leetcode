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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> tmp;
        List<TreeNode> s = new ArrayList<>(), s1;
        if (root != null) {
            s.add(root);
        }
        while (s.size() != 0) {
            tmp = new ArrayList<>();
            for (TreeNode ptr : s) tmp.add(ptr.val);
            ans.add(0, tmp);
            s1 = new ArrayList<>();
            for (TreeNode ptr : s) {
                if (ptr.left != null) s1.add(ptr.left);
                if (ptr.right != null) s1.add(ptr.right);
            }
            s = s1;
        }
        return ans;
    }
}