import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array. This is the secret to making the Two Pointer trick work.
        Arrays.sort(nums);
        
        // Initialize the closest sum with the first three numbers
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Step 2: Iterate through the array, pinning one number at a time
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;             // Pointer just after the pinned number
            int right = nums.length - 1;  // Pointer at the very end of the array
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If we found a sum closer to the target, remember it
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Step 3: Adjust the pointers based on the sum
                if (currentSum < target) {
                    // We need a larger number, so move the left pointer to the right
                    left++;
                } else if (currentSum > target) {
                    // We need a smaller number, so move the right pointer to the left
                    right--;
                } else {
                    // If currentSum == target, it's a perfect match. It can't get closer.
                    return currentSum;
                }
            }
        }
        
        return closestSum;
    }
}