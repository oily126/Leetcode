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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> valList = new ArrayList<>();
        List<Integer> ans = new ArrayList<>(k);
        inorder(root, valList);
        int n = valList.size(), pos = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                if(valList.get(i) <= target) {
                    if (target <= valList.get(i + 1)) {
                        pos = i;
                        break;
                    }
                } else {
                    pos = 0;
                    break;
                }
            } else {
                pos = n - 1;
            }
        }
        //System.out.println(valList);
        if (pos < n - 1) {
            if (Math.abs(target - valList.get(pos)) > Math.abs(valList.get(pos + 1) - target)) {
                pos++;
            }
        }
        int left = pos, right = pos + 1;
        while (k-- > 0) {
            if (left < 0) {
                ans.add(valList.get(right));
                right++;
            } else if (right >= n) {
                ans.add(valList.get(left));
                left--;
            } else {
                if (Math.abs(target - valList.get(left)) < Math.abs(valList.get(right) - target)) {
                    ans.add(valList.get(left));
                    left--;
                } else {
                    ans.add(valList.get(right));
                    right++;
                }
            }
        }
        return ans;
    }
    private void inorder(TreeNode root, List<Integer> valList) {
        if (root == null) return;
        inorder(root.left, valList);
        valList.add(root.val);
        inorder(root.right, valList);
    }
}