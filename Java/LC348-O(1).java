public class TicTacToe {
    int[][] rows;
    int[][] cols;
    int[] diagonal;
    int[] anti_diagonal;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n][2];
        cols = new int[n][2];
        diagonal = new int[2];
        anti_diagonal = new int[2];
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
        int color = player - 1;
        rows[row][color]++;
        cols[col][color]++;
        if (row == col) {
            diagonal[color]++;
        }
        if (row == cols.length - col - 1) {
            anti_diagonal[color]++;
        }
        if (rows[row][color] == rows.length
        || cols[col][color] == cols.length
        || diagonal[color] == rows.length
        || anti_diagonal[color] == cols.length) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */