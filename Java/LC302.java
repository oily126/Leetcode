public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int l = binarySearchHorizontal(0, y, m, n, false, image);
        int r = binarySearchHorizontal(y, n, m, n, true, image);
        int u = binarySearchVertical(0, x, m, n, false, image);
        int d = binarySearchVertical(x, m, m, n, true, image);
        //System.out.println(l+" "+r+" "+u+" "+d);
        return (r - l) * (d - u);
    }
    private int binarySearchHorizontal(int left, int right, int m, int n, boolean asc, char[][] image) {
        int mid;
        boolean isBlack;
        int i;
        while (left < right) {
            mid = left + (right - left) / 2;
            isBlack = false;
            for (i = 0; i < m; i++) {
                if (image[i][mid] == '1') {
                    isBlack = true;
                    break;
                }
            }
            if (isBlack == asc) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int binarySearchVertical(int left, int right, int m, int n, boolean asc, char[][] image) {
        int mid;
        boolean isBlack;
        int i;
        while (left < right) {
            mid = left + (right - left) / 2;
            isBlack = false;
            for (i = 0; i < n; i++) {
                if (image[mid][i] == '1') {
                    isBlack = true;
                    break;
                }
            }
            if (isBlack == asc) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}