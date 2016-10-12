public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l, r, sum;
        l = 0;
        r = numbers.length - 1;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum > target) {
                r = Arrays.binarySearch(numbers, l, r, target - numbers[l]);
                if (r < 0) r = ~r;
                if (numbers[l] + numbers[r] != target) r--;
            } else {
                l = Arrays.binarySearch(numbers, l, r, target - numbers[r]);
                if (l < 0) l = ~l;
            }
        }
        return new int[] {0, 0};
    }
}