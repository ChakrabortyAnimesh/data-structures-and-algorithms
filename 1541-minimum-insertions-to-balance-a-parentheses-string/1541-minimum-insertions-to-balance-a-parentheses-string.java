class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int rightNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // If we need an odd number of right parentheses, it means we 
                // have a single ')' waiting to be paired. Because right parentheses 
                // must be consecutive 'baz', a new '(' forces us to complete the previous pair immediately.
                if (rightNeeded % 2 != 0) {
                    insertions++;      // Insert the missing ')'
                    rightNeeded--;     // The previous pair is now complete
                }
                
                // Every '(' requires two ')'
                rightNeeded += 2;
            } else { // c == ')'
                // We found one of the needed right parentheses
                rightNeeded--;
                
                // If rightNeeded drops below 0, it means we have a ')' without a matching '('
                if (rightNeeded < 0) {
                    insertions++;      // Insert a missing '('
                    rightNeeded += 2;  // The inserted '(' requires two ')'. We just found one, so we still need one more.
                }
            }
        }
        
        // Add any remaining right parentheses that were never closed
        return insertions + rightNeeded;
    }
}