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
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> s = new ArrayList<>(), s1;
        int i, j, st = 0, len = 0;
        TreeNode ptr = null;
        
        if (root != null) {
            len = 1;
            s.add(root);
        }
        while (s.size() != 0) {
            s1 = new ArrayList<>();
            for (i = 0; i < s.size(); i++) {
                ptr = s.get(i);
                if (ptr != null) {
                    s1.add(ptr.left);
                    s1.add(ptr.right);
                }
            }
            if (s1.size() % 2 == 1) return false;
            //System.out.println(s1.size());
            for (i = 0; i < s1.size() / 2; i++) {
                TreeNode ptr1 = s1.get(i), ptr2 = s1.get(s1.size() - i - 1);
                if ((ptr1 == null && ptr2 != null) 
                    || (ptr1 != null && ptr2 == null)) {
                    return false;        
                }
                //if (ptr1 != null && ptr2 != null) System.out.println(ptr1.val+" "+ptr2.val);
                if (ptr1 != null && ptr2 != null && ptr1.val != ptr2.val) {
                    return false;
                }
            }
            s = s1;
        }
        return true;
    }
}