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
    public int pathSum(TreeNode root, int sum) {
        int[] ans = new int[1];
        getPathSum(root, sum, ans);
        return ans[0];
    }
    Map<Integer, Integer> getPathSum(TreeNode root, int sum, int[] ans) {
        if (root == null) return new HashMap<>();
        Map<Integer, Integer> left = getPathSum(root.left, sum, ans);
        Map<Integer, Integer> right = getPathSum(root.right, sum, ans);
        ans[0] += left.getOrDefault(sum - root.val, 0);
        ans[0] += right.getOrDefault(sum - root.val, 0);
        Map<Integer, Integer> middle = new HashMap<>();
        middle.put(root.val, 1);
        if (root.val == sum) ans[0]++;
        for (Integer l : left.keySet()) {
            middle.put(l + root.val, middle.getOrDefault(l + root.val, 0) + left.get(l));
        }
        for (Integer r : right.keySet()) {
            middle.put(r + root.val, middle.getOrDefault(r + root.val, 0) + right.get(r));
        }
        return middle;
    }
}