public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Integer minV = null;
        Stack<Integer> maxV = new Stack<>();
        int i;
        for (i = 0; i < preorder.length; i++) {
            while (maxV.size() > 0 && maxV.peek() < preorder[i]) {
                minV = maxV.pop();
            }
            if (minV != null && minV >= preorder[i]) {
                return false;
            } else {
                maxV.push(preorder[i]);
            }
        }
        return true;
    }
}