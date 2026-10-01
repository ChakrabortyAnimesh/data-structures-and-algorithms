import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp[i] holds the length of the longest increasing subsequence ending at index i
        int[] dp = new int[nums.length];
        
        // Base case: every element is an increasing subsequence of length 1
        Arrays.fill(dp, 1);
        
        int maxLength = 1;
        
        // i iterates through each element to find the LIS ending at that element
        for (int i = 1; i < nums.length; i++) {
            // j looks back at all previous elements
            for (int j = 0; j < i; j++) {
                
                // If the current element (nums[i]) is strictly greater than the previous element (nums[j])
                // we can extend the LIS ending at j by 1.
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Keep track of the overall maximum length found so far
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}