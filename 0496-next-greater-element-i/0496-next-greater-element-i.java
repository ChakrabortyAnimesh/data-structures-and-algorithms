import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Pre-compute the next greater element for every item in nums2
        for (int currentNum : nums2) {
            // While stack is not empty AND current number is greater than top of stack
            while (!stack.isEmpty() && currentNum > stack.peek()) {
                // We found the next greater element for the top of the stack
                int smallerNum = stack.pop();
                nextGreaterMap.put(smallerNum, currentNum);
            }
            // Add current number to the stack to wait for its next greater element
            stack.push(currentNum);
        }
        
        // Step 2: Build the answer for nums1 using our populated map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // .getOrDefault(key, defaultValue) safely handles numbers still left in the stack
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
}