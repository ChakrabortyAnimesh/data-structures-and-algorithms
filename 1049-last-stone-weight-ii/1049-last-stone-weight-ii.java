class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }
        
        // The maximum capacity for our "knapsack" is half the total sum
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        // Populate the DP array (exactly like Partition Equal Subset Sum)
        for (int stone : stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        
        // Find the largest subset sum that is <= totalSum / 2
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                // Return the minimum difference
                return totalSum - (2 * i);
            }
        }
        
        return 0;
    }
}