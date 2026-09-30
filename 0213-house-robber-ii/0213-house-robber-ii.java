class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // Use Integer objects so they initialize to null. 
        // This makes it easy to check if a value has been calculated yet.
        Integer[] memo1 = new Integer[nums.length];
        Integer[] memo2 = new Integer[nums.length];
        
        // Evaluate the two separate non-circular scenarios with their respective memo arrays
        int robFirst = robMemo(nums, 0, nums.length - 2, memo1);
        int skipFirst = robMemo(nums, 1, nums.length - 1, memo2);
        
        return Math.max(robFirst, skipFirst);
    }
    
    private int robMemo(int[] nums, int currentIndex, int endIndex, Integer[] memo) {
        // Base case: if we've gone past the allowed houses, return 0
        if (currentIndex > endIndex) {
            return 0;
        }
        
        // If we have already calculated the max money from this index onwards, return it
        if (memo[currentIndex] != null) {
            return memo[currentIndex];
        }
        
        // Choice 1: Skip the current house
        int skip = robMemo(nums, currentIndex + 1, endIndex, memo);
        
        // Choice 2: Rob the current house
        int rob = nums[currentIndex] + robMemo(nums, currentIndex + 2, endIndex, memo);
        
        // Store the maximum of both choices in the memo array before returning
        memo[currentIndex] = Math.max(skip, rob);
        
        return memo[currentIndex];
    }
}