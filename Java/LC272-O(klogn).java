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
        List<Integer> ans = new ArrayList<>(k);
        Stack<TreeNode> leftRoot = new Stack<>();
        Stack<TreeNode> rightRoot = new Stack<>();
        
        if (root == null) return ans;
        TreeNode ptrLess = findLessThanTarget(root, target, leftRoot);
        TreeNode ptrGreater = findGreaterThanTarget(root, target, rightRoot);
        while (ans.size() < k && (ptrLess != null || ptrGreater != null)) {
            if (ptrLess != null && ptrGreater != null) {
                int lVal = ptrLess.val, gVal = ptrGreater.val;
                System.out.println(lVal+ " "+ gVal);
                if (Math.abs(lVal - target) <= Math.abs(gVal - target)) {
                    ans.add(lVal);
                    if (lVal == gVal) {
                        ptrGreater = getGreaterThanNode(ptrGreater, rightRoot);
                    }
                    ptrLess = getLessThanNode(ptrLess, leftRoot);
                } else {
                    ans.add(gVal);
                    ptrGreater = getGreaterThanNode(ptrGreater, rightRoot);
                }
                
            } else if (ptrLess != null) {
                System.out.println(" "+ ptrLess.val);
                ans.add(ptrLess.val);
                ptrLess = getLessThanNode(ptrLess, leftRoot);
            } else {
                System.out.println(" "+ ptrGreater.val);
                ans.add(ptrGreater.val);
                ptrGreater = getGreaterThanNode(ptrGreater, rightRoot);
            }
            
        }
        return ans;
    }
    private TreeNode findLessThanTarget(TreeNode root, double target, Stack<TreeNode> leftRoot) {
        if (root == null) return null;
        if (Math.abs(target - root.val) < 1e-10) return root;
        leftRoot.push(root);
            
        if (root.val < target) {
            TreeNode node = findLessThanTarget(root.right, target, leftRoot);
            if (node == null || node.val < root.val) {
                node = root;
                leftRoot.pop();
            }
            return node;
        } else {
            TreeNode node = findLessThanTarget(root.left, target, leftRoot);
            if (node == null) leftRoot.pop();
            return node;
        }
    }
    private TreeNode findGreaterThanTarget(TreeNode root, double target, Stack<TreeNode> rightRoot) {
        if (root == null) return null;
        if (Math.abs(target - root.val) < 1e-10) return root;
        rightRoot.push(root);
            
        if (root.val < target) {
            TreeNode node = findGreaterThanTarget(root.right, target, rightRoot);
            if (node == null) rightRoot.pop();
            return node;
        } else {
            TreeNode node = findGreaterThanTarget(root.left, target, rightRoot);
            if (node == null || node.val > root.val) {
                node = root;
                rightRoot.pop();
            }
            return node;
        }
    }
    private TreeNode getLessThanNode(TreeNode node, Stack<TreeNode> leftRoot) {
        if (node == null) return null;
        if (node.left != null) {
            leftRoot.push(node);
            node = node.left;
            while (node.right != null) {
                leftRoot.push(node);
                node = node.right;
            }
            return node;
        } else {
            if (leftRoot.size() == 0) return null;
            TreeNode parent = leftRoot.pop();
            while (parent != null && parent.left == node) {
                node = parent;
                if (leftRoot.size() > 0) {
                    parent = leftRoot.pop();
                } else {
                    parent = null;
                }
            }
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }
    private TreeNode getGreaterThanNode(TreeNode node, Stack<TreeNode> rightRoot) {
        if (node == null) return null;
        if (node.right != null) {
            rightRoot.push(node);
            node = node.right;
            while (node.left != null) {
                rightRoot.push(node);
                node = node.left;
            }
            return node;
        } else {
            if (rightRoot.size() == 0) return null;
            TreeNode parent = rightRoot.pop();
            while (parent != null && parent.right == node) {
                node = parent;
                if (rightRoot.size() > 0) {
                    parent = rightRoot.pop();
                } else {
                    parent = null;
                }
            }
            if (parent != null) {
                return parent;
            }
        }
        return null;
    }
}