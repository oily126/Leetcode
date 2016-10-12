public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Integer minV = null;
        int maxP = -1;
        int i;
        for (i = 0; i < preorder.length; i++) {
            while (maxP >= 0 && preorder[maxP] < preorder[i]) {
                minV = preorder[maxP--];
            }
            if (minV != null && minV >= preorder[i]) {
                return false;
            } else {
                preorder[++maxP] = preorder[i];
            }
        }
        return true;
    }
}