class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If openCount is greater than 0, this is not an outermost '('
                if (openCount > 0) {
                    result.append(c);
                }
                openCount++;
            } else if (c == ')') {
                openCount--;
                // If openCount is greater than 0 after decrementing, this is not an outermost ')'
                if (openCount > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}