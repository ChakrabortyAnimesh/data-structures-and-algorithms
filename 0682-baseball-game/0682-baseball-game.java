import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("C")) {
                // Remove the previous score
                stack.pop();
            } else if (op.equals("D")) {
                // Double the previous score
                stack.push(stack.peek() * 2);
            } else if (op.equals("+")) {
                // Sum of the previous two scores
                int top1 = stack.pop();
                int top2 = stack.peek();
                int newScore = top1 + top2;
                
                // Put the first one back, then add the new score
                stack.push(top1);
                stack.push(newScore);
            } else {
                // It's a number, parse and push
                stack.push(Integer.parseInt(op));
            }
        }
        
        // Sum up all the valid scores remaining in the stack
        int totalSum = 0;
        while (!stack.isEmpty()) {
            totalSum += stack.pop();
        }
        
        return totalSum;
    }
}