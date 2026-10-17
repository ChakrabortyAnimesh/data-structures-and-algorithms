import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // arrPos stores {value, original_index}
        int[][] arrPos = new int[n][2];
        for (int i = 0; i < n; i++) {
            arrPos[i][0] = nums[i];
            arrPos[i][1] = i;
        }
        
        // Sort based on digit sum, then by value
        Arrays.sort(arrPos, (a, b) -> {
            int sumA = getDigitSum(a[0]);
            int sumB = getDigitSum(b[0]);
            
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        boolean[] visited = new boolean[n];
        int swaps = 0;
        
        // Traverse array elements to detect cycles
        for (int i = 0; i < n; i++) {
            // If the element is already visited or in its correct sorted position
            if (visited[i] || arrPos[i][1] == i) {
                continue;
            }
            
            // Find the size of the cycle
            int cycleSize = 0;
            int j = i;
            
            while (!visited[j]) {
                visited[j] = true;
                // Move to the index where the current element originally belonged
                j = arrPos[j][1];
                cycleSize++;
            }
            
            // If there is a cycle of size > 1, it requires cycleSize - 1 swaps
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        
        return swaps;
    }
    
    // Helper method to calculate the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}