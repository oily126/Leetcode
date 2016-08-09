public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    public int findKthLargest(int[] nums, int l, int r, int k) {
        if (l == r) {
            //for (int i = 0; i < nums.length; i++) System.out.print(nums[i]+" ");
            //System.out.println();
            return nums[r];
        }
        if (l == r - 1) {
            if (k - 1 > l) return Math.max(nums[l], nums[r]);
            else return Math.min(nums[l], nums[r]);
        }
        int i, j, pivot, mid = median3(nums, l, r);
        i = l;
        j = r;
        pivot = nums[mid];
        swap(nums, mid, r);
        
        //System.out.println(nums[l]+" "+nums[r]+" "+nums[mid]);
        while (i < j) {
            while (nums[++i] < pivot);
            while (nums[--j] > pivot);
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, r);
        //for (int i1 = 0; i1 < nums.length; i1++) System.out.print(nums[i1]+" ");
        //System.out.println();
        //System.out.println("new:"+l+" "+i+" "+j+" "+r+" with:"+k);
        if (i == k - 1) {
            return pivot;
        } else if (k > i + 1) {
            //System.out.println((i + 1) + " " + r);
            return findKthLargest(nums, i + 1, r, k);
        } else {
            //System.out.println(l + " " + (i - 1));
            return findKthLargest(nums, l, i - 1, k);
        }
    }
    public int median3(int[] nums, int l, int r) {
        int mid = l + (r - l) / 2;
        if (nums[l] > nums[mid]) {
            swap(nums, l, mid);
        }
        if (nums[l] > nums[r]) {
            swap(nums, l, r);
        }
        if (nums[mid] > nums[r]) {
            swap(nums, mid, r);
        }
        return mid;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}