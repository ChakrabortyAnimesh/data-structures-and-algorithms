class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, it cannot be divided into two equal integer halves
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        
        // dp[i] will be true if a subset with sum i is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // A sum of 0 is always possible (empty subset)
        
        // Iterate through each number in the array
        for (int num : nums) {
            // Traverse backwards to prevent reusing the same element
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        
        return dp[target];
    }
}