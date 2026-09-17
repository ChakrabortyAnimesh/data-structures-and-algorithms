/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       // Base Case 1: Both nodes are null (we've reached the end of identical branches)
        if (p == null && q == null) {
            return true;
        }
        
        // Base Case 2: One node is null, but the other isn't (structural difference)
        if (p == null || q == null) {
            return false;
        }
        
        // Base Case 3: The values of the current nodes don't match
        if (p.val != q.val) {
            return false;
        }
        
        // Recursive Step: Both current nodes match. Now check their left AND right subtrees.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
    }
}