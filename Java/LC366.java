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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        findLeaves(root, ans);
        return ans;
    }
    private int findLeaves(TreeNode root, List<List<Integer>> ans) {
        if (root == null) return 0;
        int leftDep = findLeaves(root.left, ans);
        int rightDep = findLeaves(root.right, ans);
        int rootDep = Math.max(leftDep, rightDep) + 1;
        if (ans.size() < rootDep) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(rootDep - 1).add(root.val);
        return rootDep;
    }
}