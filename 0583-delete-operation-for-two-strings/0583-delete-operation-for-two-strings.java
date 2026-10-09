class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // dp[i][j] will store the length of the LCS of word1[0...i-1] and word2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Build the DP table to find the length of LCS
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                // If characters match, add 1 to the previous diagonal
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                // If they don't match, carry over the max value from the top or left
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Length of the Longest Common Subsequence
        int lcsLength = dp[m][n];
        
        // Apply the formula
        return (m - lcsLength) + (n - lcsLength); 
        // Can also be written as: m + n - 2 * lcsLength
    }
}