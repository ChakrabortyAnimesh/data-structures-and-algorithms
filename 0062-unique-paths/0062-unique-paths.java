class Solution {
    public int uniquePaths(int m, int n) {
        // Create a memoization table to store results.
        // By default, Java initializes int arrays with 0s.
        int[][] memo = new int[m][n];
        
        return explore(0, 0, m, n, memo);
    }

    private int explore(int r, int c, int m, int n, int[][] memo) {
        // Base Case: Out of bounds
        if (r >= m || c >= n) {
            return 0;
        }
        
        // Base Case: Reached destination
        if (r == m - 1 && c == n - 1) {
            return 1;
        }
        
        // Have we already calculated the paths for this specific square?
        // If so, return the saved answer immediately instead of branching out.
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        
        // Otherwise, calculate it (Right + Down)
        int pathsGoingRight = explore(r, c + 1, m, n, memo);
        int pathsGoingDown = explore(r + 1, c, m, n, memo);
        
        // Save the result in our memo table before returning it
        memo[r][c] = pathsGoingRight + pathsGoingDown;
        
        return memo[r][c];
    }
}