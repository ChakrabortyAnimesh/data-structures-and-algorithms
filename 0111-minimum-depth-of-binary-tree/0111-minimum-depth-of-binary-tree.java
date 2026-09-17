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
    public int minDepth(TreeNode root) {
      // Base case: the tree is empty
        if (root == null) {
            return 0;
        }
        
        // Trap prevention 1: If there is no left child, we MUST go right
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // Trap prevention 2: If there is no right child, we MUST go left
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // If the node has both children, find the minimum of the two paths
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;  
    }
}