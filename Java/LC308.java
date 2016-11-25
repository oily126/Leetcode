public class NumMatrix {
    int[][] bit;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        bit = new int[matrix.length + 1][matrix[0].length + 1];
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                updateBIT(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        updateBIT(row, col, val - matrix[row][col]);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
    }
    
    private int lsb(int bit) {
        return bit & (-bit);
    }
    
    private void updateBIT(int row, int col, int diff) {
        for (int i = row + 1; i < bit.length; i += lsb(i)) {
            for (int j = col + 1; j < bit[i].length; j += lsb(j)) {
                bit[i][j] += diff;
            }
        }
    }
    
    private int getSum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= lsb(i)) {
            for (int j = col + 1; j > 0; j -= lsb(j)) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);