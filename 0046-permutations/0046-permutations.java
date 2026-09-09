import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPath, int[] nums) {
        // 1. Base Case: If the path length equals nums.length, we have a full permutation
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return; // We hit the end of this branch, stop exploring
        }

        // 2. Iterate through ALL choices every time
        for (int i = 0; i < nums.length; i++) {
            
            // 3. Constraint Check: If we already used this number, skip it
            if (currentPath.contains(nums[i])) {
                continue;
            }

            // CHOOSE
            currentPath.add(nums[i]);
            
            // EXPLORE
            backtrack(result, currentPath, nums);
            
            // UN-CHOOSE (BACKTRACK)
            currentPath.remove(currentPath.size() - 1);
        }
    }
}