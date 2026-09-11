import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        
        // Initialize an empty board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Start backtracking from row 0
        backtrack(0, board, res, n);
        return res;
    }
    
    private void backtrack(int row, char[][] board, List<List<String>> res, int n) {
        // Base case: We successfully placed n queens
        if (row == n) {
            List<String> validBoard = new ArrayList<>();
            for (char[] r : board) {
                validBoard.add(new String(r));
            }
            res.add(validBoard);
            return;
        }
        
        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {
            
            // Ask our helper function if this spot is safe
            if (isValid(board, row, col, n)) {
                
                // 1. Place the queen
                board[row][col] = 'Q';
                
                // 2. Move to the next row
                backtrack(row + 1, board, res, n);
                
                // 3. Backtrack: Remove the queen
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int row, int col, int n) {
        // 1. Check the column directly above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        // 2. Check the top-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // 3. Check the top-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // If it survives all checks, the position is safe
        return true;
    }
}