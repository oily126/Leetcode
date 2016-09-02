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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        int i, j, k;
        
        if (l > r) return ans;
        if (l == r) {
            ans.add(new TreeNode(l));
            return ans;
        }
        for (i = l; i <= r; i++) {
            List<TreeNode> leftList = helper(l, i - 1);
            List<TreeNode> rightList = helper(i + 1, r);
            TreeNode node;
            
            if (rightList.size() == 0) {
                for (j = 0; j < leftList.size(); j++) {
                    node = new TreeNode(i);
                    node.left = leftList.get(j);
                    ans.add(node);
                }
            } 
            if (leftList.size() == 0) {
                for (k = 0; k < rightList.size(); k++) {
                    node = new TreeNode(i);
                    node.right = rightList.get(k);
                    ans.add(node);
                }
            }
            for (j = 0; j < leftList.size(); j++) {
                for (k = 0; k < rightList.size(); k++) {
                    node = new TreeNode(i);
                    node.left = leftList.get(j);
                    node.right = rightList.get(k);
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}