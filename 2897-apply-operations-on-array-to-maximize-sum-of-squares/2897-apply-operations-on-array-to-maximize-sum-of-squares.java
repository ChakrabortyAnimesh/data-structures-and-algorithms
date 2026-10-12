import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        
        // Array to store the frequency of set bits at each bit position (0 to 31)
        int[] bitCounts = new int[32];
        
        // Count the number of 1s at each bit position across all numbers
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }
        
        long maxSum = 0;
        
        // Greedily construct the k largest possible numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            
            for (int bit = 0; bit < 32; bit++) {
                // If there is a '1' available at this bit position, use it
                if (bitCounts[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCounts[bit]--;
                }
            }
            
            // Add the square of the constructed number to the total sum
            // Modulo is applied to prevent long overflow during addition
            maxSum = (maxSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) maxSum;
    }
}