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
    public int largestBSTSubtree(TreeNode root) {
        int[] maxNum = new int[1];
        int[] minVal = new int[1];
        int[] maxVal = new int[1];
        minVal[0] = Integer.MIN_VALUE;
        maxVal[0] = Integer.MAX_VALUE;
        getNumberInSubtree(root, maxNum, minVal, maxVal, 0);
        return maxNum[0];
    }
    private int getNumberInSubtree(TreeNode root, int[] maxNum, int[] minVal, int[] maxVal, int dir) {
        if (root == null) return 0;
        boolean isBST = true;
        int minVal1, maxVal1, tmp1 = minVal[0], tmp2 = maxVal[0];
        minVal1 = maxVal1 = root.val;
        int leftNum = getNumberInSubtree(root.left, maxNum, minVal, maxVal, 1);
        if (leftNum >= 1) {
            //System.out.println(root.left.val+"-"+maxVal[0]+"-"+minVal[0]);
            if (maxVal[0] >= minVal1) isBST = false;
            minVal1 = minVal[0];
        }
        minVal[0] = tmp1;
        maxVal[0] = tmp2;
        int rightNum = getNumberInSubtree(root.right, maxNum, minVal, maxVal, 2);
        if (rightNum >= 1) {
            //System.out.println(root.right.val+"-"+maxVal[0]+"-"+minVal[0]);
            if (minVal[0] <= maxVal1) isBST = false;
            maxVal1 = maxVal[0];
        }
        minVal[0] = tmp1;
        maxVal[0] = tmp2;
        //System.out.println(root.val+" "+maxVal1+" "+minVal1+" ");
        if (isBST && leftNum >= 0 && rightNum >= 0) {
            maxNum[0] = Math.max(maxNum[0], leftNum + rightNum + 1);
            minVal[0] = minVal1;
            maxVal[0] = maxVal1;
            return leftNum + rightNum + 1;
        }
        return -1;
    }
}