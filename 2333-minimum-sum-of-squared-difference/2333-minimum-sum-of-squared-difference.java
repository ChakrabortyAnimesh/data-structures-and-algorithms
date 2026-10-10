class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        // Total operations we can perform is the sum of k1 and k2
        long k = (long) k1 + k2;
        
        // Count the frequencies of each absolute difference
        int[] count = new int[100001];
        long totalDiff = 0;
        int maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
            totalDiff += diff;
            maxDiff = Math.max(maxDiff, diff);
        }
        
        // If we have enough operations to reduce all differences to 0
        if (totalDiff <= k) {
            return 0;
        }
        
        // Greedily reduce the largest differences
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (count[i] > 0) {
                // The number of elements we can reduce from difference i to i-1
                long reduce = Math.min((long) count[i], k);
                
                count[i] -= reduce;
                count[i - 1] += reduce;
                k -= reduce;
            }
        }
        
        // Calculate the final minimum sum of squared differences
        long minSumSquared = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                minSumSquared += (long) count[i] * i * i;
            }
        }
        
        return minSumSquared;
    }
}