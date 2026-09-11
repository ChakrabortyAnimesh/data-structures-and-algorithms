class Solution {
    public void solveSudoku(char[][] board) {
        // Start the recursive solving process
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        // Iterate through every cell on the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                // If we find an empty cell...
                if (board[row][col] == '.') {
                    
                    // Try all possible digits from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        
                        if (isValid(board, row, col, c)) {
                            // 1. Place the digit
                            board[row][col] = c;
                            
                            // 2. Recurse. If it leads to a solution, stop and return true.
                            if (solve(board)) {
                                return true;
                            }
                            
                            // 3. Backtrack: Reset the cell if it hit a dead end
                            board[row][col] = '.';
                        }
                    }
                    // If we tried 1-9 and none worked, this board state is invalid
                    return false; 
                }
            }
        }
        // If the loops finish without returning false, there are no empty cells left!
        return true; 
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check if 'c' is already in the current row
            if (board[row][i] == c) return false;
            
            // Check if 'c' is already in the current column
            if (board[i][col] == c) return false;
            
            // Check if 'c' is in the 3x3 sub-box
            // i / 3 determines the row offset (0,0,0,1,1,1,2,2,2)
            // i % 3 determines the col offset (0,1,2,0,1,2,0,1,2)
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}