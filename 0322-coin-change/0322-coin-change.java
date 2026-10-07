class Solution {
    public int coinChange(int[] coins, int amount) {
        // We use an Integer array instead of int[] so we can check for null.
        // null means "we haven't calculated this amount yet."
        Integer[] memo = new Integer[amount + 1];
        
        // Start the recursive function
        return helper(coins, amount, memo);
    }
    
    private int helper(int[] coins, int remainingAmount, Integer[] memo) {
        // Base Case 1: We overshot the target (invalid combination)
        if (remainingAmount < 0) {
            return -1; 
        }
        
        // Base Case 2: We hit exactly 0, meaning we found a valid combination!
        if (remainingAmount == 0) {
            return 0; 
        }
        
        // Memoization Check: If we already solved for this amount, return the saved answer.
        if (memo[remainingAmount] != null) {
            return memo[remainingAmount];
        }
        
        // We haven't solved it yet. Let's try every coin.
        int minCoins = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            // Recursively find the fewest coins needed for the rest of the amount
            int result = helper(coins, remainingAmount - coin, memo);
            
            // If result is >= 0, it means the recursive call found a valid path
            if (result >= 0 && result < minCoins) {
                // We add 1 because we are using the current 'coin'
                minCoins = result + 1;
            }
        }
        
        // Save our finding in the memo array so we don't have to compute it again.
        // If minCoins is still MAX_VALUE, we never found a valid path, so save -1.
        memo[remainingAmount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        
        return memo[remainingAmount];
    }
}