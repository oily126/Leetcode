public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] partProduct = new int[nums.length];
        int[] partProduct1 = new int[nums.length];
        int i;
        partProduct[0] = nums[0];
        for (i = 1; i < nums.length; i++) {
            partProduct[i] = partProduct[i - 1] * nums[i];
        }
        partProduct1[nums.length - 1] = nums[nums.length - 1];
        for (i = nums.length - 2; i >= 0; i--) {
            partProduct1[i] = partProduct1[i + 1] * nums[i];
        }
        
        // final products store in partProduct
        partProduct1[0] = partProduct[0];
        partProduct[0] = partProduct1[1];
        for (i = 1; i < nums.length - 1; i++) {
            partProduct1[i] = partProduct[i];
            partProduct[i] = partProduct1[i - 1] * partProduct1[i + 1];
        }
        partProduct[nums.length - 1] = partProduct1[nums.length - 2];
        return partProduct;
    }
}