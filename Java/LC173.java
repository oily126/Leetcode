/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    public boolean hasNext;
    Stack<TreeNode> minNode;
    
    public BSTIterator(TreeNode root) {
        hasNext = (root != null);
        minNode = new Stack<>();
        addMins(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !minNode.empty();
    }

    /** @return the next smallest number */
    public int next() {
        if (minNode.empty()) return -1;
        TreeNode ans = minNode.pop();
        addMins(ans.right);
        return ans.val;
    }
    
    public void addMins(TreeNode root) {
        TreeNode ptr = root;
        if (ptr == null) return;
        if (minNode.empty() || ptr.val < minNode.peek().val) {
            minNode.add(ptr);
        }
        while (ptr.left != null) {
            ptr = ptr.left;
            if (minNode.empty() || ptr.val < minNode.peek().val) {
                minNode.add(ptr);
            }
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */