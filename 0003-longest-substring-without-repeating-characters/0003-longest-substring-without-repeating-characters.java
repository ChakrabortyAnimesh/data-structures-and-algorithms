import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        
        // Array to store the last seen index of each ASCII character.
        // We use 128 as the size for standard ASCII.
        int[] lastSeen = new int[128];
        
        // Initialize all values to -1 to indicate no character has been seen yet
        Arrays.fill(lastSeen, -1);
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If we have seen this character and it is inside our current window,
            // we must shrink the window by jumping the left pointer ahead of the duplicate.
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1;
            }
            
            // Update the last seen position of the current character
            lastSeen[c] = right;
            
            // The current valid window size is (right - left + 1). 
            // Update maxLength if this window is the biggest we've seen.
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}