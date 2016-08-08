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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> s = new ArrayList<>(), s1;
        List<Integer> tmp;
        int i;
        if (root != null) s.add(root);
        while (s.size() != 0) {
            tmp = new ArrayList<>();
            if (ans.size() % 2 == 1) {
                for (i = s.size() - 1; i >= 0; i--) tmp.add(s.get(i).val);
            } else {
                for (i = 0; i < s.size(); i++) tmp.add(s.get(i).val);
            }
            ans.add(tmp);
            s1 = new ArrayList<>();
            for (i = 0; i < s.size(); i++) {
                if (s.get(i).left != null) s1.add(s.get(i).left);
                if (s.get(i).right != null) s1.add(s.get(i).right);
            }
            s = s1;
        }
        return ans;
    }
}