public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> position = new HashMap<>();
        int i;
        
        for (i = 0; i < nums.length; i++) {
            int val = nums[i];
            
            if (position.containsKey(target - val)) {
                return new int[]{position.get(target - val).intValue(), i};
            }
            
            position.put(val, i);
        }
        
        return new int[0];
    }
}