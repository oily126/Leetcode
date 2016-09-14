public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i, j;
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] blk = new boolean[9];
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < 9; j++) {
                row[j] = col[j] = blk[j] = false;
            }
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] >= '0' && board[i][j] <= '9') {
                    int num = board[i][j] - '0' - 1;
                    if (row[num]) {
                        //System.out.println(1);
                        return false;
                    } else {
                        row[num] = true;
                    }
                }
                if (board[j][i] >= '0' && board[j][i] <= '9') {
                    int num = board[j][i] - '0' - 1;
                    if (col[num]) {
                        //System.out.println(2);
                        return false;
                    } else {
                        col[num] = true;
                    }
                }
                int x = i / 3 * 3 + j / 3, y = i % 3 * 3 + j % 3;
                if (board[x][y] >= '0' && board[x][y] <= '9') {
                    int num = board[x][y] - '0' - 1;
                    if (blk[num]) {
                        //System.out.println(3);
                        return false;
                    } else {
                        blk[num] = true;
                    }
                }
            }
        }
        return true;
    }
}