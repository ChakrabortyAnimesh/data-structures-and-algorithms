import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. CRITICAL: Sort the array so duplicates are adjacent
        Arrays.sort(nums);
        
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums, int start) {
        result.add(new ArrayList<>(currentPath));

        for (int i = start; i < nums.length; i++) {
            
            // 2. PRUNING: If this is NOT the first element we are looking at 
            // in this specific loop, AND it's identical to the previous element... skip it.
            if (i > start && nums[i] == nums[i - 1]) {
                continue; 
            }
            
            currentPath.add(nums[i]);
            backtrack(result, currentPath, nums, i + 1);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}