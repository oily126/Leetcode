public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        int i, j;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (helper(i, j, 1, word, board, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean helper(int x, int y, int index, String word,
        char[][] board, boolean[][] visited) {
        
        if (index >= word.length()) {
            return true;
        }
        
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int i, nx, ny;
        
        for (i = 0; i < 4; i++) {
            nx = x + direction[i][0];
            ny = y + direction[i][1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                if (!visited[nx][ny] && board[nx][ny] == word.charAt(index)) {
                    visited[nx][ny] = true;
                    if (helper(nx, ny, index + 1, word, board, visited)) {
                        return true;
                    }
                    visited[nx][ny] = false;
                }
            }
        }
        
        return false;
    }
}