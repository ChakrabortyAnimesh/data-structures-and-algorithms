import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursion with an empty list and index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums, int start) {
        // 1. Add the current subset to our result.
        // CRITICAL: We must create a new ArrayList. If we just add 'currentPath', 
        // we pass a reference, and later modifications will ruin our saved subsets.
        result.add(new ArrayList<>(currentPath));

        // 2. Iterate through the remaining choices
        for (int i = start; i < nums.length; i++) {
            
            // CHOOSE: Add the current element
            currentPath.add(nums[i]);
            
            // EXPLORE: Move to the next index
            backtrack(result, currentPath, nums, i + 1);
            
            // UN-CHOOSE (BACKTRACK): Remove the last element added 
            // so we can try the next loop iteration
            currentPath.remove(currentPath.size() - 1);
        }
    }
}