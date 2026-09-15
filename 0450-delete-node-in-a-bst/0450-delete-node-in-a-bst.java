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
    public TreeNode deleteNode(TreeNode root, int key) {
       // Base case: if the tree is empty or the key isn't found
        if (root == null) {
            return null;
        }

        // Stage 1: Search for the node to remove
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        // Stage 2: Node found, proceed with deletion
        else {
            // Case 1 & 2: Node has no children or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            // Find the inorder successor (smallest node in the right subtree)
            TreeNode minNode = findMin(root.right);
            
            // Replace the current node's value with the successor's value
            root.val = minNode.val;
            
            // Delete the inorder successor from the right subtree
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    // Helper method to find the minimum value node in a given subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    } 
}
