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
      if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; // We start at level 1
        
        while (!queue.isEmpty()) {
            // How many nodes are on the current level?
            int levelSize = queue.size(); 
            
            // Process every node on this current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                
                // If this node has zero children, it's a leaf! 
                // Because we check level by level, this is guaranteed to be the minimum depth.
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                
                // Otherwise, add its children to the line for the NEXT level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // After checking all nodes on this level, increase the depth for the next level
            depth++;
        }
        
        return depth;  
    }
}