import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array so duplicates are adjacent
        Arrays.sort(nums);
        
        // 2. Array to track which specific indexes we have already picked
        boolean[] used = new boolean[nums.length];
        
        backtrack(result, new ArrayList<>(), nums, used);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums, boolean[] used) {
        // Base Case: Path length equals array length
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return; 
        }

        for (int i = 0; i < nums.length; i++) {
            
            // Skip this element if we are already using it in the current path
            if (used[i]) {
                continue;
            }

            // PRUNING: Skip duplicates to avoid building identical branches.
            // If the current number is the same as the previous one, 
            // AND the previous one is NOT currently being used (meaning we just finished 
            // a branch with it at this exact position), skip it.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // CHOOSE
            used[i] = true;                 // Mark the index as used
            currentPath.add(nums[i]);
            
            // EXPLORE
            backtrack(result, currentPath, nums, used);
            
            // UN-CHOOSE (BACKTRACK)
            used[i] = false;                // Mark the index as unused again
            currentPath.remove(currentPath.size() - 1);
        }
    }
}