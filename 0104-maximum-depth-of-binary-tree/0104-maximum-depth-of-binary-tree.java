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
    public int maxDepth(TreeNode root) {
      // Base case: if the node is empty, its depth is 0
        if (root == null) {
            return 0;
        }
        
        // Find the max depth of the left subtree
        int leftDepth = maxDepth(root.left);
        
        // Find the max depth of the right subtree
        int rightDepth = maxDepth(root.right);
        
        // The total depth is 1 (for the root) plus the bigger of the two subtrees
        return Math.max(leftDepth, rightDepth) + 1;  
    }
}