public class TicTacToe {
    int[][] board;
    int result;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        result = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int[][] direction = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        int i, x, y, row1, col1;
        int len = 1;
        /*if (row >= board.length || col >= board[0].length 
            || col < 0 || row < 0 || board[row][col] != 0) {
            return -1;
        }*/
        board[row][col] = player;
        for (i = 0; i < direction.length; i++) {
            x = direction[i][0];
            y = direction[i][1];
            len = 1;
            len += checkDirection(x, y, row, col, player);
            len += checkDirection(-x, -y, row, col, player);
            if (len >= board.length) {
                result = player;
                return result;
            }
        }
        return result;
    }
    private int checkDirection(int x, int y, int row, int col, int player) {
        int len = 0;
        for (int i = 1; i < board.length; i++) {
            row += x;
            col += y;
            if (row >= 0 && row < board.length && col >= 0
                && col < board[0].length && board[row][col] == player) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */