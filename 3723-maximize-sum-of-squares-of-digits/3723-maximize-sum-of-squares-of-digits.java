class Solution {
    public String maxSumOfSquares(int num, int sum) {
  // If the target sum is impossible to reach with 'num' digits
        if (sum > 9 * num || sum < 1) {
            return "";
        }
        
        int countNines = sum / 9;
        int remainder = sum % 9;
        
        // Calculate the number of trailing zeros needed
        int countZeros = num - countNines - (remainder > 0 ? 1 : 0);
        
        // Use StringBuilder for O(num) time and space complexity
        StringBuilder sb = new StringBuilder(num);
        
        // Append all 9s
        for (int i = 0; i < countNines; i++) {
            sb.append('9');
        }
        
        // Append the remainder if it exists
        if (remainder > 0) {
            sb.append(remainder);
        }
        
        // Append the remaining 0s
        for (int i = 0; i < countZeros; i++) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}